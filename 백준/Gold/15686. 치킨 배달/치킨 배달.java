import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, chicken, removal, min;
    static int[][] arr;
    static int[] selected;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        list = new ArrayList<>();
        chicken = 0;
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==2) {
                    chicken++;
                    list.add(new int[]{r, c});
                }
            }
        }

        removal = chicken-M;
        selected = new int[removal];
        min = Integer.MAX_VALUE;
        combination(0, 0);

        System.out.println(min);
    }

    public static void combination(int idx, int now) {
        if(now==(removal)) {
            changeChicken(0);
            calcDistance();
            changeChicken(2);
            return;
        }

        for(int i=idx; i<=M+now; i++) {
            selected[now] = i;
            combination(i+1, now+1);
        }

    }

    public static void changeChicken(int number) {
        for(int i=0; i<removal; i++) {
            int[] tmp = list.get(selected[i]);
            arr[tmp[0]][tmp[1]] = number;
        }
    }

    public static void calcDistance() {
        int sum = 0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(arr[r][c]==1) {
                    sum += bfs(r, c);
                }
                if(sum > min) return;
            }
        }

        min = Math.min(min, sum);
    }

    public static int bfs(int r, int c) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] visited = new int[N][N];
        visited[r][c] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        int res = 0;
        out : while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = visited[now[0]][now[1]]+1;
                    if(arr[nr][nc]==2) {
                        res = visited[nr][nc]-1;
                        break out;
                    }
                }
            }
        }

        return res;
    }
}
