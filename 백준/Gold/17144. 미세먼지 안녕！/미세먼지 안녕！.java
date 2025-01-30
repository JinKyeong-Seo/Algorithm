import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr, check;
    static int[] dr, dc;
    static int R, C;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        int cleaner = 0;
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c] == -1) cleaner = r;
            }
        }

        dr = new int[]{0, 1, 0, -1};
        dc = new int[]{1, 0, -1, 0};

        for(int t=0; t<T; t++){
            spreadDust();
            airCleaner(cleaner);
        }

        int res =0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                res += arr[r][c];
            }
        }
        System.out.println(res+2);
    }

    public static void spreadDust() {
        check = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(arr[r][c] <= 0) continue;
                int cnt = 0;
                for(int d=0; d<4; d++){
                    int nr = r+dr[d];
                    int nc = c+dc[d];
                    if(nr >=0 && nr< R && nc>=0 && nc<C && arr[nr][nc] != -1) {
                        check[nr][nc] += arr[r][c]/5;
                        cnt++;
                    }
                }
                arr[r][c] -= arr[r][c]/5*cnt;
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                arr[r][c] += check[r][c];
            }
        }
    }

    public static void airCleaner(int down) {
        cleanDust(down-1, 3);
        cleanDust(down, 1);
    }

    public static void cleanDust(int sr, int direction) {
        // 위 : --, 아래 ++
        int d = 0;
        int nr = sr;
        int nc = 1;
        int prev = 0;
        int now;
        while(arr[nr][nc] != -1) {
            now = arr[nr][nc];
            arr[nr][nc] = prev;
            prev = now;

            int tr = nr + dr[d];
            int tc = nc + dc[d];
            if(tr < 0 || tr >= R || tc < 0 || tc >= C) {
                d = (d+direction)%4;
            }
            nr += dr[d];
            nc += dc[d];
        }
    }
}
