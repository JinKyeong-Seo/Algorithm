import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<int[]> pq1, pq2;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        pq1 = new PriorityQueue<>((o1, o2) -> {
            return o1[2]-o2[2];
        });

        pq2 = new PriorityQueue<>((o1, o2) -> {
            return o2[2]-o1[2];
        });

        for(int m=0; m<=M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq1.add(new int[]{a, b, w});
            pq2.add(new int[]{a, b, w});
        }

        int max = kruskal(N, true);
        int min = kruskal(N, false);

        System.out.println((int) (Math.pow(N-max, 2)-Math.pow(N-min, 2)));
    }

    public static int kruskal(int N, boolean isPq1) {
        p = new int[N+1];
        for(int n=0; n<=N; n++) p[n] = n;

        int cnt = 0;
        int res = 0;
        while(cnt < N) {
            int[] now = isPq1? pq1.poll() : pq2.poll();
            int px = find(now[0]);
            int py = find(now[1]);

            if(px==py) continue;
            cnt++;
            res+=now[2];
            union(px, py);
        }

        return res;
    }

    public static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}