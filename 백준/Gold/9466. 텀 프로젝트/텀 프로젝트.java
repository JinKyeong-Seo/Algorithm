import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[][] visited;
    static int res;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visited = new int[2][N+1];
            for(int n=1; n<=N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
                if(arr[n]==n) visited[0][n] = -1;
            }

            res = 0;
            for(int n=1; n<=N; n++){
                if(visited[0][n]==0){
                    visited[0][n] = 1;
                    visited[1][n] = n;
                    dfs(n, arr[n], 2);
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int now, int cnt){
        if(start == now) {
            return;
        } else if(visited[0][now] == -1) {
            res += (cnt-1);
            return;
        } else if (visited[0][now] != 0) {
            if(visited[1][now]==start){
                res += (visited[0][now]-1);
            } else {
                res += (cnt-1);
            }
            return;
        }

        visited[0][now] = cnt;
        visited[1][now] = start;
        dfs(start, arr[now], cnt+1);
    }
}
