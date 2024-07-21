import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] juice = new int[2][N];
        int res = 0;
        for(int n=0; n<N; n++){
            juice[0][n] = Integer.parseInt(br.readLine());
            res+=juice[0][n];
        } // 입력 끝
        
        if(N<=2) {
        	System.out.println(res);
        	return;
        }
        
    	juice[1][0] = juice[0][0];
    	juice[1][1] = juice[0][0]+juice[0][1];
    	juice[1][2] = findMax(juice[1][1], juice[0][0]+juice[0][2], juice[0][1]+juice[0][2]);
        
        for(int n=3; n<N; n++) {
        	juice[1][n] = findMax(juice[1][n-1], juice[1][n-2]+juice[0][n], juice[1][n-3]+juice[0][n-1]+juice[0][n]);
        }
        
        System.out.println(juice[1][N-1]);
    }
    public static int findMax(int i, int j, int x) {
        int res = Math.max(i, j);
        res = Math.max(res, x);
        return res;
    }
}