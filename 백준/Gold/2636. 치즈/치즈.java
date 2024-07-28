import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] cheese;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                cheese[r][c] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝
        
        int time = 1;
        int res = 0;
        while(true){
            int tmp = bfs();
            if(tmp==0) break;
            res = tmp;
            time++;
        }

        sb.append(time-1).append("\n").append(res);
        System.out.println(sb);
    }

    public static int bfs(){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] check = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        check[0][0] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr >=0 && nr<N && nc>=0 && nc<M && !check[nr][nc]){
                    if(cheese[nr][nc]==0) {
                        queue.add(new int[]{nr, nc});
                    } else {
                        if(cheese[nr][nc]==1){
                            cheese[nr][nc] = 0;
                            cnt++;
                        }
                    }
                    check[nr][nc] = true;
                }
            }
        }

        return cnt;
    }

}
