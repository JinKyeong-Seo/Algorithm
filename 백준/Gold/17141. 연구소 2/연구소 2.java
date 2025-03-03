import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] selected;
    static int N, M, V, min;
    static List<int[]> virus;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        virus = new ArrayList<>();
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==2) virus.add(new int[]{r, c});
            }
        }

        V = virus.size();
        selected = new boolean[V];
        min = Integer.MAX_VALUE;
        comb(0, 0);

        if(min==9999) min = -1;
        System.out.println(min);
    }

    public static void comb(int idx, int now) {
        if(now==M) {
            min = Math.min(min, bfs());
        }

        for(int i=idx; i<V; i++) {
            selected[i] = true;
            comb(i+1, now+1);
            selected[i] = false;
        }
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[N][N];

        for(int v=0; v<V; v++) {
            if(selected[v]) {
                queue.add(virus.get(v));
                visited[virus.get(v)[0]][virus.get(v)[1]] = 1;
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr >=0 && nr< N && nc >=0 && nc< N && arr[nr][nc] != 1 && visited[nr][nc]==0) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                }
            }
        }

        return checkArr(visited);
    }

    public static int checkArr(int[][] visited) {
        int res = 0;
        out : for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                res = Math.max(res, visited[r][c]);
                if(arr[r][c]!=1 && visited[r][c]==0) {
                    res = 10000;
                    break out;
                }
            }
        }

        return res-1;
    }
}
