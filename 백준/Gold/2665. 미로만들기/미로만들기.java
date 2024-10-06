import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int[][] room, check;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        check = new int[N][N];
        for(int r=0; r<N; r++){
            String now = br.readLine();
            for(int c=0; c<N; c++){
                room[r][c] = now.charAt(c)-'0';
                check[r][c] = Integer.MAX_VALUE;
            }
        }
        check[0][0] = 0; // 입력 끝

        queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // R, C, CNT
        bfs(N);
        System.out.println(check[N-1][N-1]);
    }

    public static void bfs(int N){
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;

                int cnt = (room[nr][nc] == 1) ? now[2] : now[2] + 1;
                if (check[nr][nc] > cnt) {
                    check[nr][nc] = cnt;
                    queue.add(new int[]{nr, nc, cnt});
                }
            }
        }
    }
}
