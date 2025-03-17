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

        p = new int[N];
        for(int n=1; n<N; n++) p[n] = n;

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = findP(a);
            int pb = findP(b);
            if(pa!=pb) union(pa, pb);
            else {
                System.out.println(m+1);
                return;
            }
        }

        System.out.println(0);
    }

    public static int findP(int x) {
        if(x != p[x]) p[x] = findP(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}
