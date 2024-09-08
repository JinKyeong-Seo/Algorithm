import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] memo;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            memo = new int[N];
            for(int n=0; n<N; n++) memo[n] = Integer.parseInt(st.nextToken());
            Arrays.sort(memo);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                sb.append(findNum(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static int findNum(int now){
        int mid = N/2;
        int left = 0;
        int right = N;

        while(left <= right && left < N){
            if (memo[mid]==now) return 1;

            if(memo[mid]<now){
                left = mid+1;
            }else{
                right = mid-1;
            }

            mid = (right+left)/2;
        }

        return 0;
    }

}
