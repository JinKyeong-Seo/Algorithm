import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];
        for(int i=0; i<N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[][] res = new int[N][2];
        int sum = 0;
        if(N<=2) {
        	for(int i=0; i<N; i++) {
        		sum+=stair[i];
        	}
        	System.out.println(sum);
        	return;
        }
        res[0][0] = stair[0];
        res[1][0] = stair[1];
        res[1][1] = stair[0]+stair[1];
        for(int i=2; i<N; i++) {
        	res[i][0] = Math.max(res[i-2][0], res[i-2][1])+stair[i];
        	res[i][1] = res[i-1][0]+stair[i];
        }
        
        System.out.println(Math.max(res[N-1][0], res[N-1][1]));
    }
}