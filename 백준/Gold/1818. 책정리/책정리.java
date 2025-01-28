import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        LIS = new int[N];
        LIS[0] = arr[0];

        int point = 1;
        for(int n=1; n<N; n++){
            if(arr[n] > LIS[point-1]){
                LIS[point++] = arr[n];
            } else {
                int idx = binarySearch(point-1, arr[n]);
                LIS[idx] = arr[n];
            }
        }

        System.out.println(N-point);
    }

    public static int binarySearch(int end, int target){
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
