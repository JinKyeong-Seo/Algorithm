import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N;
        int K;
        int[] arr;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for(int n=0; n<N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
            }

            int now = 0;
            LIS = new int[N];
            LIS[now++] = arr[0];
            for(int n=1; n<N; n++){
                if(arr[n] > LIS[now-1]) {
                    LIS[now++] = arr[n];
                } else {
                    int idx = binarySearch(now-1, arr[n]);
                    LIS[idx] = arr[n];
                }
            }

            sb.append("Case #").append(t).append("\n");
            sb.append(now >= K ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int end, int target) {
        int start = 0;
        int mid;
        while(start < end) {
            mid = (start+end)/2;
            if(LIS[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
