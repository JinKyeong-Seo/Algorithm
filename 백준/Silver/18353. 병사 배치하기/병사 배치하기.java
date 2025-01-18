import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[][] arr = new int[2][N];
        int max = 0;
        for(int i=0; i<N; i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = 1;
            for(int j=i-1; j>=0; j--){
                if(arr[0][j] > arr[0][i]) {
                    arr[1][i] = Math.max(arr[1][i], arr[1][j]+1);
                }
            }
            max = Math.max(max, arr[1][i]);
        }

        System.out.println(N-max);
    }
}
