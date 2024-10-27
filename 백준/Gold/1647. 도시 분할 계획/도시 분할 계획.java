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
        for(int n=1; n<=N; n++) p[n] = n;

        int[][] edges = new int[M][3];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            edges[m][0] = Integer.parseInt(st.nextToken());
            edges[m][1] = Integer.parseInt(st.nextToken());
            edges[m][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (o1, o2) -> {
           return o1[2]-o2[2];
        });

        int select = 0;
        int sum = 0;
        for(int m=0; m<M; m++){
            if(select==N-2) break;

            int px = findSet(edges[m][0]);
            int py = findSet(edges[m][1]);

            if (px != py){
                union(px, py);
                sum += edges[m][2];
                select++;
            }
        }
        System.out.println(sum);
    }

    static int findSet(int x){
        if(x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    static void union(int x, int y){
        p[y] = p[x];
    }
}