import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr;
    static int N, L, R, X, res;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        selectNumber(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(res);
    }

    public static void selectNumber(int idx, int sum, int min, int max) {
        if(sum > R || idx >= N) return;

        if(Math.max(max, arr[idx])-Math.min(min, arr[idx]) >= X && sum+arr[idx] >= L && sum+arr[idx]<=R) res++;
        selectNumber(idx+1, sum+arr[idx], Math.min(min, arr[idx]), Math.max(max, arr[idx]));
        selectNumber(idx+1, sum, min, max);
    }
}
