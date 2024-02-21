import java.util.*;
import java.io.*;

class Top{
	int idx;
	int floor;
	Top(){}
	Top(int idx, int floor){
		this.idx = idx;
		this.floor = floor;
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
        int[] res = new int[N+1];
        Stack<Top> stack = new Stack<>();
        Stack<Integer> arr = new Stack<>();
        for(int i=0; i<N; i++) {
        	arr.push(Integer.parseInt(st.nextToken()));
        }
        
        int idx = N;
        stack.push(new Top(idx--, arr.pop()));
        for(int i=0; i<N-1; i++) {
        	int floor = arr.pop();
        	Top now = new Top(idx--, floor);
        	while(!stack.isEmpty() && stack.peek().floor < floor) {
        		res[stack.peek().idx] = now.idx;
        		stack.pop();
        	}
        	stack.push(now);
        }
        
        for(int i=1; i<=N; i++) {
        	sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
        
    }
}