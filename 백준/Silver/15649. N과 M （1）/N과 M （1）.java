import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] select;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        visited = new boolean[N+1];

        perm(0);
        System.out.println(sb.toString().trim());
    }

    public static void perm(int now) {
        if(now == M) {
            for(int m=0; m<M; m++) {
                sb.append(select[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int n=1; n<=N; n++) {
            if(visited[n]) continue;
            visited[n] = true;
            select[now] = n;
            perm(now+1);
            visited[n] = false;
        }
    }
}
