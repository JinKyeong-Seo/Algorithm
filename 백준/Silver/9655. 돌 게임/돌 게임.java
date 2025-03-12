import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String res = "SK";
        if(N%2==0) res = "CY";

        System.out.println(res);
    }
}
