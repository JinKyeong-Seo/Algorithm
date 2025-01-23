import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
            {return o1[2]-o2[2];}
        );

        while(M!=0 && N!=0) {
            int sum = 0;
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                queue.add(new int[]{a, b, w});
                sum += w;
            }

            p = new int[N];
            for(int m=1; m<M; m++){
                p[m] = m;
            }

            int cnt = 0;
            while(cnt < (M-1)) {
                int[] now = queue.poll();

                int px = findSet(now[0]);
                int py = findSet(now[1]);

                if(px == py) continue;

                union(px, py);
                cnt++;
                sum -= now[2];
            }

            queue.clear();
            sb.append(sum).append("\n");

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    public static int findSet(int x) {
        if(x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}