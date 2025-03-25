import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] selected;
    static int N, min;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int now = Integer.parseInt(st.nextToken());
                arr[r][c] += now;
                arr[c][r] += now;
            }
        }

        selected = new boolean[N];
        min = Integer.MAX_VALUE;

        combination(0);
        System.out.println(min);
    }

    static void combination(int idx) {
        if(idx==N) {
            int now = calcDiff();
            min = Math.min(min, now);
            return;
        }

        selected[idx] = true;
        combination(idx+1);
        selected[idx] = false;
        combination(idx+1);
    }

    static int calcDiff() {
        int start = 0;
        int link = 0;

        for(int r=0; r<N-1; r++) {
            for(int c=r+1; c<N; c++) {
                if(selected[r]!=selected[c]) continue;
                if(selected[r]) {
                    start += arr[r][c];
                } else {
                    link += arr[r][c];
                }
            }
        }

        return Math.abs(start-link);
    }
}
