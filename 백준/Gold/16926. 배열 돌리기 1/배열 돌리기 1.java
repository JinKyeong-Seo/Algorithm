import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int L = Math.min(N, M)/2;
        for(int r=0; r<R; r++) {
            for(int l=0; l<L; l++) {
                rotateArr(l, l);
            }
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                sb.append(arr[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void rotateArr(int sr, int sc) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int start = arr[sr][sc];
        int nr = sr;
        int nc = sc+1;
        int d = 0;

        while(true) {
            arr[nr + dr[(d+2)%4]][nc + dc[(d+2)%4]] = arr[nr][nc];

            if(nr+dr[d]<sr || nr+dr[d]>=(N-sr) || nc+dc[d]<sc || nc+dc[d]>=(M-sc)) {
                d = (d+1)%4;
            }
            nr += dr[d];
            nc += dc[d];

            if(nr==sr && nc==sc) break;
        }

        arr[sr+1][sc] = start;
    }

}
