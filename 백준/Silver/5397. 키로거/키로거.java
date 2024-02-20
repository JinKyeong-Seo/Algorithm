import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int t=0; t<T; t++) {
			String text = br.readLine();
			for(int i=0; i<text.length(); i++) {
				char c= text.charAt(i);
				if(c=='<') {
					if(!left.isEmpty()) right.push(left.pop());
				} else if(c=='>') {
					if(!right.isEmpty()) left.push(right.pop());
				} else if(c=='-') {
					if(!left.isEmpty()) left.pop();
				} else {
					left.push(c);
				}
			}
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
