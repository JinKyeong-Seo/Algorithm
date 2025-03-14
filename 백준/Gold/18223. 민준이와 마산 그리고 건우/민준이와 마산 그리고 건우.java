import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<int[]>[] adjList;
    static int[] dist;
    static int V;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V + 1];
        for (int v = 0; v <= V; v++) adjList[v] = new ArrayList<>();

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, c});
            adjList[b].add(new int[]{a, c});
        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(1);
        int min = dist[V];
        int friend = dist[P];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(P);

        String res = "GOOD BYE";
        if(friend + dist[V] == min) res = "SAVE HIM";
        System.out.println(res);
    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1]-o2[1];
        });
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for(int[] next : adjList[now[0]]) {
                if(dist[next[0]] > dist[now[0]] + next[1]) {
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }
}
