import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] tree;
    static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[N];
        for(int n=0; n<N; n++) {
            tree[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        System.out.println(binarySearch(tree[N-1], M)-1);
    }

    public static int binarySearch(int end, int target) {
        int start = 1;
        int mid;
        while(start < end) {
            mid = (start+end)/2;
            if(calcLength(mid) < target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static long calcLength(int distance) {
        long sum = 0;
        for(int n=0; n<N; n++) {
            if(tree[n] < distance) continue;
            sum += (tree[n]-distance);
        }
        return sum;
    }
}
