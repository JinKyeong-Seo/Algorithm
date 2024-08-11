import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int n=0; n<N; n++){
            set.add(br.readLine());
        }
        String[] str = set.toArray(new String[set.size()]);

        Arrays.sort(str, (o1, o2)->{
            if(o1.length()==o2.length()) return o1.compareTo(o2);
            else return o1.length()-o2.length();
        });

        for(int i=0; i<str.length; i++){
            sb.append(str[i]).append("\n");
        }

        System.out.println(sb);
    }
}