import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] alchol;
    static int N, K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alchol = new int[N];
        long end = 0;
        for(int n=0; n<N; n++) {
            alchol[n] = Integer.parseInt(br.readLine());
            end = Math.max(end, alchol[n]);
        }

        System.out.println(binarySearch(end));
    }

    public static long binarySearch(long end){
        long start = 1;
        long mid = 0;
        long max = 0;
        while(start<=end){
            mid = (start+end)/2;

            int cnt = 0;
            for(int n=0; n<N; n++){
                cnt += alchol[n]/mid;
            }

            if(cnt >= K) {
                max = Math.max(max, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }
}