import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static String[] arr, selected;
    static boolean[] check;
    static int n, k;
    static Set<Integer> hash;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        selected = new String[k];
        check = new boolean[n];
        hash = new HashSet<>();
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        comb(0);
        System.out.println(hash.size());
    }

    public static void comb(int idx){
        if(idx == k){
            String str = "";
            for(int i=0; i<k; i++){
                str+=selected[i];
            }
            hash.add(Integer.parseInt(str));
            return;
        }

        for(int i=0; i<n; i++){
            if(!check[i]){
                check[i] = true;
                selected[idx] = arr[i];
                comb(idx+1);
                check[i] = false;
            }
        }
    }
}
