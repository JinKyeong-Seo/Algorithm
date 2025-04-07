import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] flower;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] month = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        flower = new int[N][2];
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            flower[n][0] = month[a-1]+b;
            flower[n][1] = month[c-1]+d;
        }

        Arrays.sort(flower, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        int res = 0;
        if(flower[0][0] <= 60) {
            res = findFlower();
        }
        System.out.println(res);
    }

    static int findFlower() {
        int limit = 60;
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        for(int n=0; n<N; n++) {
            if(flower[n][0] <= limit) {
                max = Math.max(max, flower[n][1]);
            } else {
                if(flower[n][0] > max) {
                    max = -1;
                    break;
                }
                limit = max;
                max = flower[n][1];
                cnt ++;
            }

            if(flower[n][0] > 334 || max > 334) break;
        }

        return max > 334 ? cnt : 0;
    }
}
