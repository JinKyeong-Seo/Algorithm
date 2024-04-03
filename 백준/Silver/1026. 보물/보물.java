import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> A = new PriorityQueue<>();
		PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		for(int i=0; i<N; i++) {
			res += (A.poll()*B.poll());
		}
		
		System.out.println(res);
	}
}
