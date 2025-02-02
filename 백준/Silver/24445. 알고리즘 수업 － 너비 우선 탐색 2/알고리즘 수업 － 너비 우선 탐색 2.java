import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int n=0; n<=N; n++) adjList[n] = new ArrayList<>();
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for(int n=1; n<=N; n++){
            adjList[n].sort(Collections.reverseOrder());
        }

        visited = new int[N+1];
        visited[R] = 1;
        bfs(R);

        for(int n=1; n<=N; n++){
            sb.append(visited[n]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int cnt = 2;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int n : adjList[now]){
                if(visited[n]!=0) continue;
                queue.add(n);
                visited[n] = cnt++;
            }
        }
    }
}
