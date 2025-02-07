import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visited;
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
            visited = new boolean[N][N];
            boolean flag = false;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(!visited[r][c]) {
                        visited[r][c] = true;
                        boolean res = movePeople(r, c);
                        if(res) flag = true;
                    }
                }
            }

            if(!flag) break;
            day++;
        }

        System.out.println(day);
    }

    public static boolean movePeople(int sr, int sc) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int sum = arr[sr][sc];
        int cnt = 1;

        List<int[]> country = new ArrayList<>();
        country.add(new int[]{sr, sc});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int d=0; d<4; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
                    int tmp = Math.abs(arr[now[0]][now[1]]-arr[nr][nc]);
                    if(tmp < L || tmp > R) continue;
                    queue.add(new int[]{nr, nc});
                    country.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    sum += arr[nr][nc];
                    cnt++;
                }
            }
        }

        int people = sum/cnt;
        for(int[] now : country) {
            arr[now[0]][now[1]] = people;
        }

        return cnt > 1;
    }

}
