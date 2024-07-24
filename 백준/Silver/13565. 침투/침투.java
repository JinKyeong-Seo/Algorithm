import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int M, N;
    static int[][] fiber;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        fiber = new int[M][N];
        queue = new LinkedList<>();
        for (int r = 0; r < M; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                fiber[r][c] = str.charAt(c)-'0';
                if(r==0&&fiber[r][c]==0) {
                    queue.add(new int[]{r, c});
                    fiber[r][c] = 1;
                }
            }
        }// 입력 끝

        if(bfs()) System.out.println("YES");
        else System.out.println("NO");
        
    }

    public static boolean bfs(){
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==M-1) return true;
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<M && nc>=0 && nc<N && fiber[nr][nc]==0){
                    queue.add(new int[]{nr, nc});
                    fiber[nr][nc] = 1;
                }
            }
        }
        return false;
    }
}
