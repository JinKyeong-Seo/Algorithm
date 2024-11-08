import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<int[]> queue;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            arr[r][c] = 1;
        }

        int max = Integer.MIN_VALUE;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c]==1 && !visited[r][c]){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    max = Math.max(max, bfs(N, M));
                }
            }
        }
        System.out.println(max);
    }

    public static int bfs(int N, int M){
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int cnt = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr >= 0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
