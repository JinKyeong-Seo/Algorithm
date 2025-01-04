import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for(int n=N-1; n>=0; n--){
            res += K/arr[n];
            K %= arr[n];
        }

        System.out.println(res);
    }
}
