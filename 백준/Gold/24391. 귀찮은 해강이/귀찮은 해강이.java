import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        for(int n=1; n<=N; n++){
            p[n] = n;
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = find(a);
            int pb = find(b);

            if(pa==pb) continue;
            union(pa, pb);
        }

        for(int n=1; n<=N; n++) find(n);

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int n=0; n<N-1; n++) {
            int now = Integer.parseInt(st.nextToken());
            if(p[prev] != p[now]) cnt++;
            prev = now;
        }

        System.out.println(cnt);
    }

    public static int find(int x) {
        if( x != p[x] ) p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}
