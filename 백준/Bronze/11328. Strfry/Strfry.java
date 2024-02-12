import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			String one = st.nextToken();
			String two = st.nextToken();
			int[] arr = new int[26];
			
			for(int i=0; i<one.length(); i++) {
				char c = one.charAt(i);
				++arr[c-'a'];
			}
			
			for(int i=0; i<two.length(); i++) {
				char c = two.charAt(i);
				--arr[c-'a'];
			}
			
			int res=0;
			for(int i=0; i<arr.length; i++) {
				res+=Math.abs(arr[i]);
			}
			
			if(res==0) sb.append("Possible\n");
			else sb.append("Impossible\n");
		}
		System.out.println(sb.toString());
	}
}
