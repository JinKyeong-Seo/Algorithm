import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr;
    static int N, M, L;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        arr[N] = L;

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int start = 1;
        int end = L;
        int mid;

        while(start < end) {
            mid = (start+end)/2;

            int cnt = countRest(mid);

            if(cnt > M) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static int countRest(int distance) {
        int prev = 0;
        int res = 0;
        for(int n=0; n<=N; n++) {
            int now = arr[n] - prev - 1;
            res += now/distance;
            prev = arr[n];
        }

        return res;
    }
}
