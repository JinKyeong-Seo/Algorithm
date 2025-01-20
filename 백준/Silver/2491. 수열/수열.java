import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[][] arr = new int[3][N+1]; // 오 내

        int max = 1;
        for(int n=1; n<=N; n++){
            arr[0][n] = Integer.parseInt(st.nextToken());

            if(arr[0][n] > arr[0][n-1]) {
                arr[1][n] = arr[1][n-1]+1;
                arr[2][n] = 1;
            } else if (arr[0][n] < arr[0][n-1]){
                arr[1][n] = 1;
                arr[2][n] = arr[2][n-1]+1;
            } else {
                arr[1][n] = arr[1][n-1]+1;
                arr[2][n] = arr[2][n-1]+1;
            }

            max = Math.max(max, Math.max(arr[1][n], arr[2][n]));
        }
        System.out.println(max);
    }
}
