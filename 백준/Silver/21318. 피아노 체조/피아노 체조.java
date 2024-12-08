import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] music = new int[N];
        int[] check = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            music[n] = Integer.parseInt(st.nextToken());
            if(n>0) {
                if(music[n] < music[n-1]) check[n-1]++;
                check[n] = check[n-1];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int res = 0;
            if(y!=0){
                res = check[y-1];
                if(x!=0){
                    res -= check[x-1];
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
