import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adjList;
    static int[] degree;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int n=1; n<=N; n++) {
            adjList[n] = new ArrayList<>();
        }

        degree = new int[N+1];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            degree[b]++;
        }

        topologicalSorting();
        System.out.println(sb);
    }

    public static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();

        for(int n=1; n<=N; n++) {
            if(degree[n]==0) queue.add(n);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for(int next : adjList[now]) {
                degree[next]--;
                if(degree[next]==0) queue.add(next);
            }
        }
    }
}
