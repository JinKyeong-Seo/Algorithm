import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lines = new long[K];

        long end = 0;
        for(int k=0; k<K; k++){
            lines[k] = Long.parseLong(br.readLine());
            end = Math.max(end, lines[k]);
        }
        end+=1;

        long maxLine = 0;
        long start = 0;
        long mid;
        while(start<end) {
            long cnt = 0;
            mid = (start+end)/2;
            for(int k=0; k<K; k++){
                cnt += lines[k]/mid;
            }

            if(cnt >= N){
                start = mid+1;
                maxLine = Math.max(maxLine, mid);
            } else {
                end = mid;
            }
        }

        System.out.println(maxLine);
    }
}
