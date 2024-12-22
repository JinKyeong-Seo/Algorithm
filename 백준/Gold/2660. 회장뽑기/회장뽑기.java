import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] res;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(a==-2 && b==-2) break;

            arr[a][b] = true;
            arr[b][a] = true;
        }

        res = new int[N];
        int min = 1000;
        for(int n=0; n<N; n++){
            res[n] = bfs(n);
            min = Math.min(min, res[n]);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder candidates = new StringBuilder();
        int cnt = 0;
        for(int n=1; n<=N; n++){
            if(min==res[n-1]) {
                cnt++;
                candidates.append(n).append(" ");
            }
        }
        sb.append(min).append(" ").append(cnt).append("\n");
        sb.append(candidates);
        System.out.println(sb);
    }

    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(start);
        visited[start] = true;

        int time = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0; s<size; s++){
                int now = queue.poll();
                for(int n=0; n<N; n++){
                    if(arr[now][n] && !visited[n]){
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            time++;
        }
        return time;
    }
}
