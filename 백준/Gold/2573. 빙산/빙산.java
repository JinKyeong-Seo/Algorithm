import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr, visited;
    static int N, M;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝


        queue = new LinkedList<>();
        int time = -1;
        boolean flag;
        while(true) {
            time++;
            visited = new int[N][M];

            int cnt = 0;
            flag = false;
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(arr[r][c] != 0 && visited[r][c]==0) {
                        visited[r][c] = 1;
                        queue.add(new int[]{r, c});
                        bfs();
                        flag = true;
                        cnt++;
                    }
                }
            }

            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    if(visited[r][c]>=1) arr[r][c] = Math.max(arr[r][c]-visited[r][c]+1, 0);
                }
            }
            if(!flag || cnt>=2) break;
        }

        if(!flag) time = 0;
        System.out.println(time);
    }

    public static void bfs(){
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int zero = 1;
            for(int d=0; d<4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr >=0 && nr<N && nc>=0 && nc<M) {
                    if(arr[nr][nc]!=0 && visited[nr][nc]==0) {
                        visited[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                    if(arr[nr][nc]==0) zero++;
                }
            }
            visited[now[0]][now[1]] = zero;
        }
    }
}
