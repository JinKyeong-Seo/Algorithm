import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String M = st.nextToken();
			if(M.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if (M.equals("pop")) {
				if(queue.isEmpty()) sb.append(-1);
				else sb.append(queue.poll());
				sb.append("\n");
			} else if (M.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (M.equals("empty")) {
				if(queue.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append("\n");
			} else if (M.equals("front")) {
				if(queue.isEmpty()) sb.append(-1);
				else sb.append(queue.peekFirst());
				sb.append("\n");
			} else {
				if(queue.isEmpty()) sb.append(-1);
				else sb.append(queue.peekLast());
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
