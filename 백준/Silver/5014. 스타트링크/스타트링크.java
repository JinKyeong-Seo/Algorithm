import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] building = new int[F+1];
		building[S] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		while(!queue.isEmpty()) {
			int gangho = queue.poll();
			if(gangho==G) {
				System.out.println(building[G]-1);
				return;
			}
			
			if(gangho-D >= 1 && building[gangho-D] == 0) {
				building[gangho-D] = building[gangho]+1;
				queue.add(gangho-D);
			}
			
			if(gangho+U <= F && building[gangho+U] == 0) {
				building[gangho+U] = building[gangho]+1;
				queue.add(gangho+U);
			}
		}
		System.out.println("use the stairs");
	}
}
