import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int n=1; n<=N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
            }

            int cycle = 0;
            for(int n=1; n<=N; n++){
                if(!visited[n]){
                    cycle++;
                    check(n);
                }
            }
            sb.append(cycle).append("\n");
        }

        System.out.println(sb);
    }

    public static void check(int n){
        if(visited[n]) return;

        visited[n] = true;
        check(arr[n]);
    }
}
