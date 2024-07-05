import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        int[] playground = new int[N];
        int[] check = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<N; n++){
            playground[n] = Integer.parseInt(st.nextToken());
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            check[a] += h;
            if((b+1)<N) check[b+1] += h*(-1);
        } // 입력 완료

        for(int n=1; n<N; n++){
            check[n] += check[n-1];
            playground[n] += check[n];
            sb.append(playground[n]).append(" ");
        }
        System.out.println(sb);

    }
}
