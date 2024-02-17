import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] rollcake;
    static int N, L, fake, real, fakemax, realmax;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        rollcake = new int[L+1];
        fakemax = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if((end-start)>fakemax) {
                fakemax = end-start; // 기대 : 가장 많은 조각
                fake = i; // 기대 : 해당 사람
            }
            int cnt = 0;
            for(int j=start; j<=end; j++) {
                if(rollcake[j]==0) {
                    rollcake[j] = i;
                    cnt++; 
                }
            }
            if(realmax<cnt) {
                realmax = cnt; // 실제 : 가장 많은 조각
                real = i; // 실제 : 해당 사람
            }
        }
        System.out.print(fake+"\n"+real);
    }
}