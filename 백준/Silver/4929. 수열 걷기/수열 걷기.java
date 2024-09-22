import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] check;
    static int[] one, two;
    static int onePrev, twoPrev, res;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N==0) break;

            check = new int[2][20002];
            onePrev = 0;
            twoPrev = 0;
            res = 0;

            one = new int[N+1];
            for(int n=1; n<=N; n++) {
                one[n] = Integer.parseInt(st.nextToken());
                check[0][one[n]+10001] = n;
                one[n]+=one[n-1];
            }
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            two = new int[M+1];
            for(int m=1; m<=M; m++){
                int now = Integer.parseInt(st.nextToken());
                if(m>1) two[m]=two[m-1]+now;
                else if(m==1) two[1] = now;
                check[1][now+10001] = m;
                if(check[0][now+10001]!=0) {
                    calcMax(now+10001);
                }
            } // 입력 끝

            int a = one[N]-one[onePrev];
            int b = two[M]-two[twoPrev];
            res += Math.max(a, b);
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    public static void calcMax(int idx){
        int a = one[check[0][idx]] - one[onePrev];
        int b = two[check[1][idx]] - two[twoPrev];
        res += Math.max(a, b);

        onePrev = check[0][idx];
        twoPrev = check[1][idx];
    }
}
