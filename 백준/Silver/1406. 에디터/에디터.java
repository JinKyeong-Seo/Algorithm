import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i=0; i<text.length(); i++) {
			left.push(text.charAt(i));
		}
		
		for(int m=0; m<M; m++) {
			String now = br.readLine();
			if(now.equals("L")) {
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (now.equals("D")) {
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if (now.equals("B")) {
				if (!left.isEmpty()) {
					left.pop();
				}
			} else {
				char c =now.charAt(2);
				left.push(c);
			}
		}
		

		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}
}
