import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static char[][] land;
    static int N, M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        land = new char[N][M];
        for(int n=0; n<N; n++) {
            String str = br.readLine();
            for(int m=0; m<M; m++) {
                land[n][m] = str.charAt(m);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(land[n][m]=='L') {
                    max = Math.max(max, bfs(n, m));
                }
            }
        }

        System.out.println(max-1);
    }

    static int bfs(int sr, int sc) {
        int[][] visited = new int[N][M];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        visited[sr][sc] = 1;

        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && land[nr][nc]=='L' && visited[nr][nc]==0) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                }
            }

            max = Math.max(max, visited[now[0]][now[1]]);
        }

        return max;
    }
}
