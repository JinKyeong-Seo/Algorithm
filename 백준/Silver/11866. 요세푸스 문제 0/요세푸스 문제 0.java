import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		int cnt = 0;
		while(!(queue.size()==1)) {
			int now = queue.poll();
			cnt++;
			if(cnt == K) {
				sb.append(now).append(", ");
				cnt = 0;
			}
			else queue.add(now);
		}
		
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}
}
