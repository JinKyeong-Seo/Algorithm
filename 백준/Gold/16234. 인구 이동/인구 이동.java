import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr, visited;
    static int N, L, R;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            visited = new int[N][N];
            int cnt = 0;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(visited[r][c] == 0) {
                        visited[r][c] = ++cnt;
                        movePeople(r, c, cnt);
                    }
                }
            }

            if(cnt == N*N) break;
            day++;
        }

        System.out.println(day);
    }

    public static void movePeople(int sr, int sc, int num) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int sum = arr[sr][sc];
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc] == 0) {
                    int tmp = Math.abs(arr[now[0]][now[1]]-arr[nr][nc]);
                    if(tmp < L || tmp > R) continue;
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = num;
                    sum += arr[nr][nc];
                    cnt++;
                }
            }
        }

        int people = sum/cnt;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(visited[r][c] == num) {
                    arr[r][c] = people;
                }
            }
        }
    }

}
