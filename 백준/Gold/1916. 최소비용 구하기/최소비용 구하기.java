import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<int[]>[] adjList;
    static int[] dist;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        for(int n=0; n<=N; n++) adjList[n] = new ArrayList<>();

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.add(new int[]{start, 0});

        boolean[] visited = new boolean[N+1];

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
