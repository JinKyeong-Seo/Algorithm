import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] index = new String[N+1];
        Map<String, Integer> word = new HashMap<>();
        for(int n=1; n<=N; n++){
            index[n] = br.readLine();
            word.put(index[n], n);
        }

        for(int m=0; m<M; m++){
            String now = br.readLine();
            try{
                int idx = Integer.parseInt(now);
                sb.append(index[idx]).append("\n");

            } catch (NumberFormatException e){
                sb.append(word.get(now)).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
