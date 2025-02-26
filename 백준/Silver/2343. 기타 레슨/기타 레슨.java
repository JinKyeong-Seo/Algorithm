import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr;
    static int N, M, min;
    public static void main(String[] args) throws IOException {
        br =  new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int start = -1;
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[n]);
        }

        System.out.println(binarySearch(start));
    }

    public static int binarySearch(int max) {
        int start = max;
        int end = 1000000000;
        int mid;

        while(start<end) {
            mid = (start+end)/2;

            if(splitVideo(mid) > M) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static int splitVideo(int limit){
        int cnt = 1;
        int tmp = 0;
        for(int n=0; n<N; n++) {
            tmp += arr[n];
            if(tmp > limit) {
                tmp = arr[n];
                cnt++;
            }
        }

        return cnt;
    }
}
