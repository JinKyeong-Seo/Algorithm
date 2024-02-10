import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br;
	public static void main(String args[]) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		int bar = 0;
		char before = '-';
		for (int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			if(c=='(') {
				stack.push(c);
			}
			else {
				if(before=='(') {
					stack.pop();
					bar+=stack.size();
				} else {
					stack.pop();
					bar++;
				}
			}
			before = c;
		}
		System.out.println(bar);
	}
}