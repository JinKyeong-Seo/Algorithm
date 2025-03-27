import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new boolean[10];

        if(M > 0) st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        if(N==100) {
            System.out.println(0);
            return;
        }

        int min = Integer.MAX_VALUE;
        for(int n=0; n<=999999; n++) {
            String str = String.valueOf(n);
            int size = str.length();

            boolean flag = false;
            for(int s=0; s<size; s++) {
                if(arr[str.charAt(s)-'0']) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                min = Math.min(min, Math.abs(N-n) + size);
            }
        }

        System.out.println(Math.min(min, Math.abs(N-100)));
    }
}
