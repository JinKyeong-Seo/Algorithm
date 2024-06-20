import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(recur(A, B, C));
	}
	
	public static long recur(int a, int b, int c) {
		if(b==0) return 1;
		
		long now = recur(a, b/2, c);
		if(b%2==0) {
			return (now*now)%c;
		} else {
			return (now*now%c)*a%c;
		}
	}
}
