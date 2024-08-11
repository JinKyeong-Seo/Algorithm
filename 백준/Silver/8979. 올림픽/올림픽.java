import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] nations = new int[N][4];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            nations[n][0] = Integer.parseInt(st.nextToken());
            nations[n][1] = Integer.parseInt(st.nextToken());
            nations[n][2] = Integer.parseInt(st.nextToken());
            nations[n][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nations, (o1, o2) ->{
            if(o1[1]==o2[1]){
                if(o1[2]==o2[2]) return o1[3]-o2[3];
                else return o1[2]-o2[2];
            } else return o1[1]-o2[1];
        });

        int idx = 0;
        for(int i=0; i<N; i++){
            if(nations[i][0]==K){
                idx = i;
                break;
            }
        }

        int cnt = 0;
        for(int j=idx+1; j<N; j++){
            if(nations[j][1]==nations[idx][1]&&
            nations[j][2]==nations[idx][2]&&
            nations[j][3]==nations[idx][3]) cnt++;
            else break;
        }

        System.out.println(N-(idx+cnt));
    }
}
