import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<=n; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int n=N-2; n>=0; n--) {
            for(int m=0; m<=n; m++) {
                arr[n][m] += Math.max(arr[n+1][m], arr[n+1][m+1]);
            }
        }

        System.out.println(arr[0][0]);
    }
}
