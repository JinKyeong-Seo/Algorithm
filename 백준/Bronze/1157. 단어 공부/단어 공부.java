import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().toUpperCase();
        int[] arr = new int[26];
        for(int i=0; i<text.length(); i++) {
        	int c = text.charAt(i)-'A';
            arr[c]++;
        }
        
        int maxIdx = 0;
        String alpha = Character.toString('A'+0); 
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]>arr[maxIdx]) {
        		maxIdx = i;
        		alpha = Character.toString('A'+i);
        	}
        }
        
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]==arr[maxIdx]) {
        		cnt++;
        	}
        }
        if(cnt>=2) {
        	alpha = "?";
        }
        System.out.println(alpha);
    }
}