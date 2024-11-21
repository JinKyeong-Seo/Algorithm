import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] budgets;
    static int N, M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        budgets = new int[N];
        int sum = 0;
        int end = 0;
        for(int n=0; n<N; n++){
            budgets[n] = Integer.parseInt(st.nextToken());
            sum+=budgets[n];
            end = Math.max(end, budgets[n]);
        }
        M = Integer.parseInt(br.readLine());

        // 1. 가능
        if (sum<=M) {
            System.out.println(end);
        } else { // 2. 불가능
            int res = binarySearch(0, end);
            System.out.println(res);
        }

    }

    public static int binarySearch(int start, int end){
        int mid = 0;
        int max = 0;
        while(start<end){
            mid = (start+end)/2;

            int[] res = check(mid);
            if(res[0]==0){
                end = mid;
            } else {
                start = mid+1;
                max = Math.max(max, mid);
            }
        }
        return max;
    }

    public static int[] check(int mid){
        int sum = 0;
        int max = -1;
        for(int n=0; n<N; n++){
            int now = Math.min(budgets[n], mid);
            sum += now;
            max = Math.max(max, now);
        }

        return new int[]{sum <= M ? 1 : 0, max};
    }
}
