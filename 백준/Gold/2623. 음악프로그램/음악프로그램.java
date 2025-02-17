import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adjList;
    static int[] p;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        adjList = new ArrayList[N + 1];
        for (int n = 0; n <= N; n++) adjList[n] = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());
            int next;
            for (int c = 1; c < cnt; c++) {
                next = Integer.parseInt(st.nextToken());
                adjList[curr].add(next);
                p[next]++;
                curr = next;
            }
        }

        topologicalSorting();
        for (int n = 1; n <= N; n++) {
            if (p[n] != 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);
    }

    public static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();

        for (int n = 1; n <= N; n++) {
            if (p[n] == 0) queue.add(n);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append("\n");

            for (int next : adjList[now]) {
                p[next]--;
                if (p[next] == 0) queue.add(next);
            }
        }
    }
}