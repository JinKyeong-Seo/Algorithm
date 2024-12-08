import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] items = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            items[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items);

        int res = 0;
        for(int n=0; n<N; n++){
            if(P < 200) {
                res++;
                P += items[n];
            } else {
                break;
            }
        }

        System.out.println(res);
    }
}
