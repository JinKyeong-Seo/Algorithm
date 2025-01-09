import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adjList;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        for(int n=0; n<N; n++){
            adjList[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjList[a].add(b);
            adjList[b].add(a);
        }

        visited = new int[N];
        visited[0] = 1;
        bfs();

        int max = 0;
        int idx = -1;
        int cnt = 0;
        for(int n=N-1; n>=0; n--){
            if(visited[n] > max){
                max = visited[n];
                idx = n;
                cnt = 1;
            } else if (visited[n] == max){
                cnt++;
                idx = n;
            }
        }
        idx++;
        max--;
        sb.append(idx).append(" ").append(max).append(" ").append(cnt);
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : adjList[now]){
                if(visited[next]!=0) continue;
                queue.add(next);
                visited[next] = visited[now]+1;
            }
        }
    }
}
