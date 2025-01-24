import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        lis = new int[N];
        int now = 1;
        lis[0] = arr[0];
        for(int n=1; n<N; n++){
            if(arr[n] > lis[now-1]) {
                lis[now++] = arr[n];
            } else {
                int idx = searchIndex(now-1, arr[n]);
                lis[idx] = arr[n];
            }
        }

        System.out.println(N-now);
    }

    public static int searchIndex(int end, int target) {
        int start = 0;
        int mid;
        while(start < end){
            mid = (start+end)/2;

            if(target > lis[mid]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
