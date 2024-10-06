import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[2][501];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            line[0][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=500; i++){
            for(int j=i; j>=0; j--){
                if(line[0][i]>line[0][j]) line[1][i] = Math.max(line[1][i], line[1][j]+1);
            }
            max = Math.max(max, line[1][i]);
        }

        System.out.println(N-max);
    }
}
