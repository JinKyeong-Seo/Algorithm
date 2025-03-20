import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr, visited;
    static int N, M;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        visited[0][0] = arr[0][0];
        dp();

        System.out.println(visited[N-1][M-1]);
    }

    public static void dp() {
        for(int m=1; m<M; m++) visited[0][m] = arr[0][m] + visited[0][m-1];

        int[][] tmp = new int[2][M];
        for(int n=1; n<N; n++) {
            tmp[0][0] = visited[n-1][0] + arr[n][0];
            tmp[1][M-1] = visited[n-1][M-1] + arr[n][M-1];
            for(int m=1; m<M; m++) {
                tmp[0][m] = Math.max(visited[n-1][m], tmp[0][m-1]) + arr[n][m];
                tmp[1][M-m-1] = Math.max(visited[n-1][M-m-1], tmp[1][M-m]) + arr[n][M-m-1];
            }
            for(int m=0; m<M; m++) {
                visited[n][m] = Math.max(tmp[0][m], tmp[1][m]);
            }
        }
    }
}
