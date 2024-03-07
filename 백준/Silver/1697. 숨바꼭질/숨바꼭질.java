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
		int[] arr = new int[100002];
		
		arr[N] = 1;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		
		while(arr[K]==0) {
			int num = queue.poll();
            for (int nxt : new int[]{num - 1, num + 1, 2 * num}) {
                if (nxt < 0 || nxt > 100000) continue;
                if (arr[nxt] != 0) continue;
                arr[nxt] = arr[num] + 1;
                queue.add(nxt);
            }
		}
		
		System.out.println(arr[K]-1);
		
	}

}
