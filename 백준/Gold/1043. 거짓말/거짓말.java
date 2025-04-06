import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] truth, p;
    static List<Integer>[] party;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        truth = new int[T];
        for(int t=0; t<T; t++) {
            truth[t] = Integer.parseInt(st.nextToken());
        }

        p = new int[N+1];
        for(int n=0; n<=N; n++) p[n] = n;

        party = new ArrayList[M];
        for(int m=0; m<M; m++) {
            party[m] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            party[m].add(a);
            int pa = findP(a);
            for(int p=1; p<P; p++) {
                int b = Integer.parseInt(st.nextToken());
                int pb = findP(b);
                if(pa!=pb) union(pa, pb);
                party[m].add(b);
            }
        }

        int res = 0;
        for(int m=0; m<M; m++) {
            int a = party[m].get(0);
            int pa = findP(a);
            boolean flag = false;
            for(int t=0; t<T; t++) {
                int pt = findP(truth[t]);
                if(pa==pt) {
                    flag = true;
                    break;
                }
            }

            if(!flag) res++;
        }

        System.out.println(res);
    }

    static int findP(int x) {
        if(x != p[x]) p[x] = findP(p[x]);
        return p[x];
    }

    static void union(int x, int y) {
        p[y] = p[x];
    }
}
