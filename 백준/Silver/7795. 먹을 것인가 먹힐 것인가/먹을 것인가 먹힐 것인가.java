import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                A[n] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                B[m] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            sb.append(cnt()).append("\n");
        }
        System.out.println(sb);
    }

    public static int cnt() {
        int count = 0;
        for(int n=N-1; n>=0; n--) {
            count += binarySearch(A[n]);
            if(A[n]<=B[0]) break;
        }
        return count;
    }

    public static int binarySearch(int target) {
        int start = 0;
        int end = M;
        int mid;
        while(start < end) {
            mid = (start+end)/2;
            if(B[mid]>=target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
