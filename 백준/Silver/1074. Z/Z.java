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
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(check(N, r, c));
	}
	
	static int check(int N, int r, int c) {
		if(N==0) {
			return 0;
		}
		
		int half = (int) Math.pow(2, N-1);
		if(r<half && c<half) {
			return check(N-1, r, c);
		} else if(r<half && c>=half) {
			return half*half + check(N-1, r, c-half);
		} else if(r>=half && c<half) {
			return 2*half*half + check(N-1, r-half, c);
		} else {
			return 3*half*half + check(N-1, r-half, c-half);
		}

	}
}
