import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p = new int[N+1];
        for(int n=1; n<=N; n++){
            p[n] = n;
        }

        for(int n=0; n<N-2; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = find(a);
            int pb = find(b);

            if(pa == pb) continue;
            union(pa, pb);
        }

        for(int n=1; n<=N; n++) {
            find(n);
        }

        for(int n=2; n<=N; n++) {
            if(p[n] != p[1]) {
                sb.append(p[1]).append(" ").append(p[n]);
                break;
            }
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if( x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}
