import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<int[]>[] adjList;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int X = Integer.parseInt(st.nextToken()); // 하루 거리
        int Y = Integer.parseInt(st.nextToken()); // 성현 집

        adjList = new ArrayList[N];
        for(int n=0; n<N; n++) {
            adjList[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, c});
            adjList[b].add(new int[]{a, c});
        }

        visited = new boolean[N];
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(Y);

        Arrays.sort(dist);
        int day = 1;
        int tmp = 0;
        for(int n=0; n<N; n++) {
            if(dist[n] * 2 > X) {
                day = -1;
                break;
            }

            tmp += dist[n] * 2;
            if(tmp > X) {
                day++;
                tmp = dist[n] * 2;
            }
        }

        System.out.println(day);
    }

    public static void dijkstra(int Y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        dist[Y] = 0;

        pq.add(new int[]{Y, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(visited[now[0]]) continue;

            visited[now[0]] = true;
            for(int[] v : adjList[now[0]]) {
                if(!visited[v[0]] && dist[v[0]] > dist[now[0]]+v[1]) {
                    dist[v[0]] = dist[now[0]] + v[1];
                    pq.add(new int[]{v[0], dist[v[0]]});
                }
            }
        }
    }
}