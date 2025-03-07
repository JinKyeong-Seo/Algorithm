import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static int[] dr, dc;
    static int jr, jc, cnt, R, C;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for(int r=0; r<R; r++) {
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                arr[r][c] = str.charAt(c);
                if(arr[r][c]=='I') {
                    jr = r;
                    jc = c;
                }
            }
        }

        dr = new int[]{1, 1, 1, 0, 0, 0, -1, -1, -1};
        dc = new int[]{-1, 0, 1, -1, 0, 1, -1, 0, 1};
        cnt = 0;
        arduino(br.readLine());
        System.out.println(sb);
    }

    public static void arduino(String moving) {
        int size = moving.length();
        for(int s=0; s<size; s++) {
            arr[jr][jc] = '.';
            int d = moving.charAt(s)-'1';
            jr += dr[d];
            jc += dc[d];
            cnt++;

            if(arr[jr][jc]=='R') {
                sb.append("kraj ").append(cnt);
                return;
            }
            arr[jr][jc] = 'I';

            if(crazyArduino()) return;
        }

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
    }

    public static boolean crazyArduino() {
        int[][] visited = new int[R][C];
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(arr[r][c]!='R') continue;
                int distance = Integer.MAX_VALUE;
                int sr = r;
                int sc = c;
                for(int d=0; d<9; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    int tmp = calcDistance(nr, nc);
                    if(tmp < distance) {
                        distance = tmp;
                        sr = nr;
                        sc = nc;
                    }
                }

                if(arr[sr][sc]=='I') {
                    sb.append("kraj ").append(cnt);
                    return true;
                }
                visited[sr][sc]++;
                arr[r][c] = '.';
            }
        }

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(visited[r][c] == 1) {
                    arr[r][c] = 'R';
                }
            }
        }
        return false;
    }

    public static int calcDistance(int nr, int nc) {
        return Math.abs(jr-nr) + Math.abs(jc-nc);
    }
}
