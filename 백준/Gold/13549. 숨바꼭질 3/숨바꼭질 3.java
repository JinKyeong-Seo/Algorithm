import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		arr[N] = 1;
		queue.add(N);
		while(!queue.isEmpty()) {
			int now = queue.poll();	
			if(0<=now+1 && now+1<=100000 && (arr[now+1]==0 ||arr[now]+1<arr[now+1])) {
				arr[now+1] = arr[now]+1;
				queue.add(now+1);
			}
			if(0<=now-1 && now-1<=100000 && (arr[now-1]==0 ||arr[now]+1<arr[now-1])) {
				arr[now-1] = arr[now]+1;
				queue.add(now-1);
			}
			if(0<=now*2 && now*2<=100000 && (arr[now*2]==0 ||arr[now]<arr[now*2])) {
				arr[now*2] = arr[now];
				queue.add(now*2);
			}
		}
		
		System.out.println(arr[K]-1);
	}
}
