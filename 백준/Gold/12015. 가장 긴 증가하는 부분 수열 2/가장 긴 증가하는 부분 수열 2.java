import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] lis;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        lis = new int[N];

        for(int n=0; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());

        int now = 0;
        lis[now++] = arr[0];
        for(int n=1; n<N; n++){
            if(arr[n] > lis[now-1]){
                lis[now++] = arr[n];
            } else {
                int idx = binarySearch(now-1, arr[n]);
                lis[idx] = arr[n];
            }
        }

        System.out.println(now);
    }

    public static int binarySearch(int end, int target){
        int start = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(lis[mid] < target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
