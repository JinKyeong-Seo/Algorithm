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
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int n=1; n<N; n++){
            arr[n] += arr[n-1];
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            int res = arr[b];
            if(a>0) res-=arr[a-1];
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}

