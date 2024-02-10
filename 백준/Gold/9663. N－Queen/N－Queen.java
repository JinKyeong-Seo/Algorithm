import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int N;
    static int res = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        queen(0);
        System.out.println(res);
    }
    
    public static void queen(int depth) {
    	if (depth==N) {
    		res++;
    		return;
    	}
    	
    	for (int c=0; c<N; c++) {
    		arr[depth] = c;
    		if(check(depth)) {
    			queen(depth+1);
    		}      
        }
    }
    
    public static boolean check(int c) {
    	for (int i=0; i<c; i++) {
    		if(arr[c]==arr[i]) return false;
    		else if(Math.abs(arr[c]-arr[i])==Math.abs(c-i)) return false;
    	}
    	return true;
    }
}