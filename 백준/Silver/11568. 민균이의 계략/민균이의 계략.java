import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N];

        st = new StringTokenizer(br.readLine());
        int max = 1;
        for(int n=0; n<N; n++){
            arr[0][n] = Integer.parseInt(st.nextToken());
            arr[1][n] = 1;
            for(int m=n-1; m>=0; m--){
                if(arr[0][m] < arr[0][n]){
                    arr[1][n] = Math.max(arr[1][n], arr[1][m]+1);
                }
            }
            max = Math.max(max, arr[1][n]);
        }

        System.out.println(max);
    }
}
