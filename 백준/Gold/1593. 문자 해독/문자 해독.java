import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] Wcnt, Scnt;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();

        Wcnt = new int[52];
        Scnt = new int[52];

        for(int i=0; i<w; i++){
            arrCount(W.charAt(i), Wcnt, 1);
        }

        int res = 0;
        int cnt = 0;
        for(int i=0; i<s; i++){
            arrCount(S.charAt(i), Scnt, 1);
            cnt++;

            if (cnt==w){
                if(Arrays.equals(Wcnt, Scnt)) res++;
                arrCount(S.charAt(i-w+1), Scnt, -1);
                cnt--;
            }
        }
        System.out.println(res);

    }

    public static void arrCount(char c, int[] arr, int cnt){
        if('a'<= c && c <= 'z'){
            arr[c-'a'] += cnt;
        } else {
            arr[c-'A'+26] += cnt;
        }
    }

}
