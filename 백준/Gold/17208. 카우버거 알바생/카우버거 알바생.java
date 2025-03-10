import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][][] dp;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][2];
        for(int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][M+1][K+1];

        for(int n=0; n<=N; n++) {
            for(int m=0; m<=M; m++) {
                for(int k=0; k<=K; k++) {
                    dp[n][m][k] = -1;
                }
             }
        }

        System.out.println(dynamicProgramming(0, M, K));
    }

    public static int dynamicProgramming(int idx, int burger, int fries) {
        if(idx == N) return 0;
        if(dp[idx][burger][fries] != -1) return dp[idx][burger][fries];

        if(arr[idx+1][0] <= burger && arr[idx+1][1] <= fries) {
            dp[idx][burger][fries] = dynamicProgramming(idx+1, burger-arr[idx+1][0], fries-arr[idx+1][1]) + 1;
        }

        dp[idx][burger][fries] = Math.max(dp[idx][burger][fries], dynamicProgramming(idx+1, burger, fries));
        return dp[idx][burger][fries];
    }
}
