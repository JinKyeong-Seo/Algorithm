import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for(int i=0; i<N; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);

        System.out.println(binarySearch(N, M));
    }

    public static int binarySearch(int n, int m) {
        int start = 0;
        int end = trees[n-1];
        while(start<=end){
            int mid = (start+end)/2;
            long res = 0;
            for(int i=0; i<n; i++){
                res += Math.max(trees[i]-mid, 0);
            }
            if(res<m){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start-1;
    }
}
