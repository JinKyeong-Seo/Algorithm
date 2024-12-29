import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine().trim());
            int A = Integer.parseInt(st.nextToken());
            if(A==0){
                int res = -1;
                if(!pq.isEmpty()){
                    res = pq.poll();
                }
                sb.append(res).append("\n");
            } else {
                for(int a = 0; a<A; a++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
