import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int N, S;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[2][N+1];
        for(int n=1; n<=N; n++) {
            arr[0][n] = Integer.parseInt(st.nextToken());
            arr[1][n] = arr[1][n-1] + arr[0][n];
        }

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        if(arr[1][N] < S) return 0;

        int start = 1;
        int end = N;
        int mid;

        while(start<end) {
            mid = (start+end)/2;

            if(calcArr(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static boolean calcArr(int distance) {
        boolean flag = false;
        for(int n=distance; n<=N; n++) {
            int tmp = arr[1][n] - arr[1][n-distance];
            if(tmp >= S) {
                flag = true;
                break;
            }
        }

        return flag;
    }

}
