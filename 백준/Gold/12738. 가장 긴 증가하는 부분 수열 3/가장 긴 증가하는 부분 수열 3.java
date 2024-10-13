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
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int p = 0;
        LIS = new int[N];
        LIS[p++] = arr[0];
        for(int i=1; i<N; i++){
            if(LIS[p-1] < arr[i]){
                LIS[p++] = arr[i];
                continue;
            }
            int idx = binarySearch(p, arr[i]);
            LIS[idx] = arr[i];

        }
        System.out.println(p);
    }

    public static int binarySearch(int p, int now) {
        int start = 0;
        int end = p;
        while(start<=end){
            int mid = (start+end)/2;

            if(LIS[mid]<now){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
