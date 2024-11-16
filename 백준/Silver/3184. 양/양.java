import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] field;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int R, C;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        field = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                field[r][c] = str.charAt(c);
            }
        }

        queue = new LinkedList<>();
        int wolf = 0;
        int sheep = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if((field[r][c]=='v' || field[r][c]=='o') && !visited[r][c]){
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    int[] now = bfs();
                    if(now[1]>now[0]) sheep += now[1];
                    else wolf += now[0];
                }
            }
        }
        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb);
    }
    public static int[] bfs(){
        int wolf = 0;
        int sheep = 0;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(field[now[0]][now[1]]=='v') wolf++;
            else if(field[now[0]][now[1]]=='o') sheep++;
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<R && nc>=0 && nc<C && field[nr][nc]!='#' && !visited[nr][nc]){
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return new int[]{wolf, sheep};
    }
}
