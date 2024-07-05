import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken())+1;
        int[][] bag = new int[N][2]; // W V
        for(int n=1; n<N; n++){
            st = new StringTokenizer(br.readLine());
            bag[n][0] = Integer.parseInt(st.nextToken());
            bag[n][1] = Integer.parseInt(st.nextToken());
        }

        int[][] selection = new int[N][K];
        for(int n=1; n<N; n++){
            for(int k=1; k<K; k++){
                if(bag[n][0]<=k) {
                    selection[n][k] = Math.max(selection[n-1][k], selection[n-1][k-bag[n][0]]+bag[n][1]);
                } else {
                    selection[n][k] = selection[n-1][k];
                }

            }
        }

        System.out.println(selection[N-1][K-1]);
    }
}
