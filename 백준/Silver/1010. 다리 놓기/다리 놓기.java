import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        memo = new int[31][31];

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(comb(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int comb(int n, int r) {
        if(memo[n][r] != 0) return memo[n][r];

        if(n==r || r==0) return 1;
        else return memo[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}
