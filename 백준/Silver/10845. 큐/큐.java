import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String m = st.nextToken();
			if(m.equals("push")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			} else if(m.equals("pop")) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if(m.equals("size")) {
				sb.append(dq.size()).append("\n");
			} else if(m.equals("empty")) {
				if(!dq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
			} else if(m.equals("front")) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else {
				if(!dq.isEmpty()) {
					sb.append(dq.peekFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
