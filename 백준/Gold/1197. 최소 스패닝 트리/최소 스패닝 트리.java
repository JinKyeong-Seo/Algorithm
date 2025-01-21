import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[E][3];
        for(int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[e] = new int[]{a, b, c};
        }

        Arrays.sort(arr, (v1, v2) -> {
            return (v1[2]-v2[2]);
        });

        p = new int[V+1];
        for(int v=1; v<=V; v++){
            p[v] = v;
        }

        int cnt = 0;
        int sum = 0;
        for(int e=0; e<E; e++){
            int px = findSet(arr[e][0]);
            int py = findSet(arr[e][1]);

            if(px == py) continue;

            union(px, py);
            cnt++;
            sum += arr[e][2];

            if(cnt == (V-1)) break;
        }

        System.out.println(sum);
    }

    public static int findSet(int x) {
        if(x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    public static void union(int x, int y) {
        p[y] = p[x];
    }
}
