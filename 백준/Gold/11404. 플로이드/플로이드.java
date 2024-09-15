import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] city = new int[N+1][N+1];
        for(int n=1; n<=N; n++){
            Arrays.fill(city[n], INF);
            city[n][n] = 0;
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(city[a][b] > w) city[a][b] = w;
        } // 입력 끝

        for(int n=1; n<=N; n++){
            for(int a=1; a<=N; a++){
                for(int b=1; b<=N; b++){
                    if(city[a][n]!=INF && city[n][b]!=INF){
                        city[a][b] = Math.min(city[a][b], city[a][n]+city[n][b]);
                    }
                }
            }
        }

        for(int a=1; a<=N; a++){
            for(int b=1; b<=N; b++){
                int now = city[a][b];
                if(now==INF) now = 0;
                sb.append(now).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
