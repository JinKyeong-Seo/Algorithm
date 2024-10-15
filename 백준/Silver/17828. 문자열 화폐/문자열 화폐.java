import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        char[] arr = new char[N];
        Arrays.fill(arr, 'A');

        if(!isValid(N, X)) sb.append("!");
        else {
            X -= N;
            for(int i=N-1; i>=0; i--){
                if(X>0){
                    if(X>=25) {
                        arr[i] += 25;
                        X -= 25;
                    } else {
                        arr[i] += X;
                        X = 0;
                    }
                }
                sb.append(arr[i]);
            }
        }
        sb.reverse();
        System.out.println(sb);
    }

    public static boolean isValid(int N, int X){
        boolean valid = true;
        if (N>X || X>N*26) valid = false;
        return valid;
    }
}