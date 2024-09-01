import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        p = new int[N+1];
        String res = "YES";

        for(int i=1; i<=N; i++) p[i] = i;

        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) union(r, c);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int startP = findSet(start);
        for(int m=1; m<M; m++){
            int end = Integer.parseInt(st.nextToken());
            if(startP != findSet(end)) {
                res = "NO";
                break;
            }
        }

        System.out.println(res);
    }

    public static int findSet(int x){
        if(x!=p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    public static void union(int x, int y){
        x = findSet(x);
        y = findSet(y);

        if(x!=y){
            if(x<y) p[y] = x;
            else p[x] = y;
        }
    }
}