import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<Integer> queue;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int n=0; n<=N; n++){
            adjList[n] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int res = bfs();
        System.out.println(res);
    }

    public static int bfs() {
        int res = 0;

        for(int i=0; i<2; i++){
            int size = queue.size();
            for(int s=0; s<size; s++){
                int now = queue.poll();
                for(int next : adjList[now] ) {
                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                    res++;
                }
            }
        }

        return res;
    }
}