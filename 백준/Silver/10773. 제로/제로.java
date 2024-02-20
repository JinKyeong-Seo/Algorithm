import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int res = 0;
		Stack<Integer> money = new Stack<>();
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				money.pop();
			} else {
				money.push(num);
			}
		}
		
		while(!money.isEmpty()) {
			res+=money.pop();
		}
		
		System.out.println(res);
	}
}
