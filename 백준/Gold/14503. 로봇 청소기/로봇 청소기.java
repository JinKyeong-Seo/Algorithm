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
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int[] start = new int[3];
        for(int i=0; i<3; i++) start[i] = Integer.parseInt(st.nextToken());

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int res = cleanRoom(start);
        System.out.println(res);
    }

    public static int cleanRoom(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int res = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(arr[now[0]][now[1]]==0) {
                arr[now[0]][now[1]] = 2;
                res++;
            } // 1

            boolean flag = false;
            int D = now[2];
            for(int d=0; d<4; d++){
                D = (D+3)%4;
                int nr = now[0] + dr[D];
                int nc = now[1] + dc[D];
                if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==0) {
                    flag = true;
                    break;
                }
            }

            if(!flag){ //2
                int nr = now[0] + dr[(now[2]+2)%4];
                int nc = now[1] + dc[(now[2]+2)%4];
                if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]!=1) {
                    queue.add(new int[]{nr, nc, now[2]});
                }
            } else { //3
                int nr = now[0] + dr[D];
                int nc = now[1] + dc[D];
                queue.add(new int[]{nr, nc, D});
            }
        }

        return res;
    }
}
