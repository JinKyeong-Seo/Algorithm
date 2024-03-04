import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr, sel;
    static int N, M;
    public static void main(String args[]) throws Exception
    {
         br = new BufferedReader(new InputStreamReader(System.in));
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         arr = new int[N];
         sel = new int[M];
         List<Integer> list = new ArrayList<>();
         for(int i=0; i<N; i++) {
             list.add(Integer.parseInt(st.nextToken()));
         }
         Collections.sort(list);
         for(int i=0; i<N; i++) {
             arr[i] = list.get(i);
         }
         
         comb(0, 0);
         System.out.println(sb);
    }
    
    static void comb(int idx, int sidx) {
        if(sidx==M) {
            for(int i=0; i<M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=idx; i<=N-M+sidx; i++) {
            sel[sidx] = arr[i];
            comb(i+1, sidx+1);
        }
        
    }
}

