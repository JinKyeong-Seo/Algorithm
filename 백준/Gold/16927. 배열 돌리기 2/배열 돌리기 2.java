import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int D = Math.min(N, M)/2;
        for(int d=0; d<D; d++) {
            int limit = (N+M-4*d)*2-4;
            int count = R%limit;
            for(int c=0; c<count; c++) {
                rotateArr(d);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                sb.append(arr[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void rotateArr(int depth) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int n = N-depth;
        int m = M-depth;

        int start = arr[depth][depth];
        int nr = depth;
        int nc = depth+1;
        int d = 0;

        while(true) {
            arr[nr+dr[(d+2)%4]][nc+dc[(d+2)%4]] = arr[nr][nc];

            int tr = nr + dr[d];
            int tc = nc + dc[d];
            if(tr < depth || tr >= n || tc < depth || tc >= m) {
                d++;
            }

            nr += dr[d];
            nc += dc[d];
            if(nr==depth && nc==depth) break;
        }

        arr[depth+1][depth] = start;
    }
}
