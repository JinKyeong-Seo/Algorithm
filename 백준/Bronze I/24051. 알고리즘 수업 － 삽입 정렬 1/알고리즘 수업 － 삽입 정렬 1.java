import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = -1;
        out : for(int i=1; i<N; i++) {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key<arr[j]) {
            	arr[j+1] = arr[j];
            	K--;
            	if (K==0) {
            		res = arr[j];
            		break out;
            	}
            	j--;
            }
            if(j+1!=i) {
            	arr[j+1] = key;
            	K--;
            	if (K==0) {
            		res = key;
            		break out;
            	}
            }
        }
        System.out.println(res);
    }
}