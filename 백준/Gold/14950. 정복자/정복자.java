import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<int[]> pq;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        for(int n=0; n<=N; n++) {
            p[n] = n;
        }

        pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2]-o2[2];
        });

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new int[]{A, B, C});
        }

        System.out.println(kruskal(t));;
    }

    public static int kruskal(int t) {
        int time = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int pa = findP(now[0]);
            int pb = findP(now[1]);

            if(pa != pb) {
                union(pa, pb);
                sum += now[2] + t*time++;
            }
        }
        return sum;
    }

    public static int findP(int x) {
        if(x != p[x]) p[x] = findP(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}
