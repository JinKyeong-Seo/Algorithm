import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			deque.add(i);
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(deque.getFirst()==target) {
				deque.pollFirst();
				continue;
			}
			int idx = deque.indexOf(target);
			int mid = (deque.size()-1)/2;
			if(idx<=mid) {
				while(deque.getFirst()!=target) {
					cnt++;
					deque.add(deque.pollFirst());
				}
			} else {
				while(deque.getFirst()!=target) {
					cnt++;
					deque.addFirst(deque.pollLast());
				}
			}
			deque.pollFirst();
		}
		
		System.out.println(cnt);
	}
}
