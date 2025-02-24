import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, res;
    static int[][] arr;
    static boolean[] selected;
    static ArrayList<int[]> house, chicken;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==1) {
                    house.add(new int[]{r, c});
                } else if(arr[r][c]==2) {
                    chicken.add(new int[]{r, c});
                }
            }
        }

        selected = new boolean[chicken.size()];
        res = Integer.MAX_VALUE;
        selectChicken(0, 0);
        System.out.println(res);
    }

    public static void selectChicken(int idx, int now) {
        if(now==M) {
            int sum = calcDistance();
            res = Math.min(res, sum);
            return;
        }

        int C = chicken.size();
        for(int i=idx; i<C; i++) {
            selected[i] = true;
            selectChicken(i+1, now+1);
            selected[i] = false;
        }
    }

    public static int calcDistance() {
        int sum = 0;

        int C = chicken.size();
        for (int[] nh : house) {
            int min = Integer.MAX_VALUE;
            for (int c = 0; c < C; c++) {
                if (!selected[c]) continue;
                int[] nc = chicken.get(c);
                int distance = Math.abs(nh[0] - nc[0]) + Math.abs(nh[1] - nc[1]);
                min = Math.min(min, distance);
            }
            sum += min;
        }

        return sum;
    }
}
