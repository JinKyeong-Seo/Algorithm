import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] p, cnt;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p = new int[1000001];
        cnt = new int[1000001];

        for(int n=1; n<=1000000; n++) {
            p[n] = n;
            cnt[n] = 1;
        }

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            String o = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            if(o.equals("I")) {
                int b = Integer.parseInt(st.nextToken());

                int pa = findSet(a);
                int pb = findSet(b);
                if(pa != pb) union(pa, pb);
            } else {
                int pa = findSet(a);
                sb.append(cnt[pa]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int findSet(int x) {
        if(x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        cnt[x] += cnt[y];
        p[p[y]] = x;
    }
}
