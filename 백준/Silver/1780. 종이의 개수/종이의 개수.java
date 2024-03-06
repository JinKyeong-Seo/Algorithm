import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, prev;
    static int[] res = new int[3];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        check(N, 0, 0);
        for(int i=0; i<3; i++) {
        	sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
        
    }
    
    static int check(int n, int r, int c) {
        prev = arr[r][c];
        for(int row=r; row<r+n; row++) {
            for(int col=c; col<c+n; col++) {
                if(arr[row][col]!=prev) {
                	int nine = n/3;
                    check(nine, r, c);
                    check(nine, r, c+nine);
                    check(nine, r, c+nine*2);
                    check(nine, r+nine, c);
                    check(nine, r+nine, c+nine);
                    check(nine, r+nine, c+nine*2);
                    check(nine, r+nine*2, c);
                    check(nine, r+nine*2, c+nine);
                    check(nine, r+nine*2, c+nine*2);
                    return 0;
                }
            }
        }
        return res[prev+1]++;
        
    }
}