import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] hunter;
    static int M, L;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        hunter = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++) {
            hunter[m] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunter);

        int res = 0;
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c > L) continue;
            if(binary(r, c)) res++;
        }
        System.out.println(res);
    }

    public static boolean binary(int r, int c) {
        int start = 0;
        int end = M-1;
        int mid;
        int min = Integer.MAX_VALUE;
        while(start<end) {
            mid = (start+end)/2;
            min = Math.min(min, calcDistance(hunter[mid], r, c));
            if(hunter[mid] > r) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        min = Math.min(min, calcDistance(hunter[start], r, c));
        return min <= L;
    }

    public static int calcDistance(int h, int r, int c) {
        return Math.abs(h-r) + c;
    }
}
