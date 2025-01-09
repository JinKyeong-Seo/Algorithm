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

        HashMap<String, String> hash = new HashMap<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), st.nextToken());
        }

        for(int m=0; m<M; m++){
            sb.append(hash.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
