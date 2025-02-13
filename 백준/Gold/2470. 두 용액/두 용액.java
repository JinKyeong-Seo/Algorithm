import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        twoPointer(N-1);
        System.out.println(sb);
    }

    public static void twoPointer(int end) {
        int left = 0;
        int right = end;

        int min = Integer.MAX_VALUE;
        int[] res = new int[2];

        int now;
        while(left < right) {
            now = arr[left]+arr[right];
            if(Math.abs(now) < min) {
                min = Math.abs(now);
                res[0] = arr[left];
                res[1] = arr[right];
            }

            if(now > 0) {
                right--;
            } else if(now < 0) {
                left++;
            } else {
                break;
            }
        }

        sb.append(res[0]).append(" ").append(res[1]);
    }
}