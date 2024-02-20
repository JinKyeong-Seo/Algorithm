import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(int i=0; i<N; i++) {
        	int key = Integer.parseInt(br.readLine());
        	while(num<=key) {
        		stack.push(num++);
        		sb.append("+").append("\n");
        	}
        	if(stack.peek()==key) {
        		stack.pop();
        		sb.append("-").append("\n");
        	} else {
        		System.out.println("NO");
        		return;
        	}
        }
        System.out.println(sb);
    }
}