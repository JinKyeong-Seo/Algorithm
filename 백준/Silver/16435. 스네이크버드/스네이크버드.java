import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(find(L, N));
    }

    public static int find(int start, int N) {
        int now = start;
        for(int n=0; n<N; n++) {
            if(arr[n] <= now) {
                now++;
            } else {
                break;
            }
        }
        return now;
    }
}
