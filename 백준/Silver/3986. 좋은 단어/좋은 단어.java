import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		int res = 0;
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int s=0; s<str.length(); s++) {
				Character now = str.charAt(s);
				if(stack.isEmpty()) {
					stack.push(now);
				} else {
					if(stack.peek().equals(now)) {
						stack.pop();
					} else {
						stack.push(now);
					}
				}				
			}
			if(stack.isEmpty()) res ++;
			stack = new Stack<>();
		}
		System.out.println(res);
	}
}
