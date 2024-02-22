import java.util.*;
import java.io.*;

class Num{
	int idx;
	int number;
	int NGE = -1;
	
	Num(int idx, int number){
		this.idx = idx;
		this.number = number;
	}
}

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Num[] nums = new Num[N];
		Stack<Num> stack = new Stack<>();
		
		int idx = 0;
		int number = Integer.parseInt(st.nextToken());
		nums[0] = new Num(idx++, number);
		stack.push(nums[0]);
		for(int i=0; i<N-1; i++) {
			number = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty() && stack.peek().number<number) {
				stack.peek().NGE = number;
				stack.pop();
			}
			nums[idx] = new Num(idx, number);
			stack.push(nums[idx++]);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(nums[i].NGE).append(" ");
		}
		System.out.println(sb);
	}
}
