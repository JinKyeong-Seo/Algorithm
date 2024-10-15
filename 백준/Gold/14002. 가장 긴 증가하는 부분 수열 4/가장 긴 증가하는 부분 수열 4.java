import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] LIS, RECORD;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int p = 0;
        LIS = new int[N];
        RECORD = new int[N];
        LIS[p++] = arr[0];
        for(int i=1; i<N; i++){
            int idx = p;
            if(LIS[p-1] < arr[i]){
                LIS[p++] = arr[i];
            } else {
                idx = binarySearch(p-1, arr[i]);
                LIS[idx] = arr[i];
            }
            RECORD[i] = idx;
        }

        sb.append(p).append("\n");
        int[] res = new int[p];
        for(int i=N-1; i>=0; i--){
            if(RECORD[i]==(p-1)){
                res[--p] = arr[i];
            }
        }
        for(int r : res) sb.append(r).append(" ");

        System.out.println(sb);
    }

    public static int binarySearch(int limit, int value){
        int start = 0;
        int end = limit;
        while(start<=end){
            int mid = (start+end)/2;
            if(LIS[mid] < value){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
