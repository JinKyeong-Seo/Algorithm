import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int res = 0;
		int sum = 1;
		out : for(int i=0; i<str.length(); i++) {
			Character now = str.charAt(i);
			if (now == '(') {
				sum *= 2;
				stack.push(now);
			} else if (now == '[') {
				sum *= 3;
				stack.push(now);
			} else if (now == ')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					res = 0;
					break out;
				} else if (str.charAt(i-1)=='('){
					res += sum;
				}
				stack.pop();
				sum /= 2;
			} else if (now == ']') {
				if (stack.isEmpty() || stack.peek()!='[') {
					res = 0;
					break out;
				} else if (str.charAt(i-1)=='[') {
					res += sum;
				}
				stack.pop();
				sum /= 3;
			}
		}
		
		if(!stack.isEmpty()) res = 0;
		System.out.println(res);
	}
}