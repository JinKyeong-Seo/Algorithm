import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		arr[1] = 0;
		
		for(int i=2; i<=N; i++) {
			arr[i] = arr[i-1]+1;
			if(i%2==0) arr[i] = Math.min(arr[i], arr[i/2]+1);
			if(i%3==0) arr[i] = Math.min(arr[i], arr[i/3]+1);
		}
		
		System.out.println(arr[N]);
    }
}
