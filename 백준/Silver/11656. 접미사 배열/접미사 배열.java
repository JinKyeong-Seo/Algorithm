import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        List<String> list = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            list.add(S.substring(i));
        }

        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
