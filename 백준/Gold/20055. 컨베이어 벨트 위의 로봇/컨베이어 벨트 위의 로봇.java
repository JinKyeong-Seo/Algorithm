import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) * 2;
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int res = 0;
		Queue<Integer> robot = new LinkedList<>();
		boolean[] isRobot = new boolean[N];

		while (true) {
			// 1. 한바퀴 회전
			start = (start-1+N)%N;

			// 2. 첫번째 로봇부터 이동
			int size = robot.size();
			for (int i = 0; i < size; i++) {
				int now = robot.poll();
				int next = (now + 1) % N;
				if(now==(start+(N-1)/2)%N) {
					isRobot[now] = false;
				} 
				else {
					if (belt[next] != 0 && !isRobot[next]) {
						belt[next]--;
						isRobot[now] = false;
						if (next != (start+(N-1)/2)%N) {
							robot.add(next);
							isRobot[next] = true;
						} 
					} else {
						robot.add(now);
					}					
				}
				
			}
			// 3. 0번에 로봇 올리기
			if (belt[start] != 0) {
				robot.add(start);
				belt[start]--;
				isRobot[start] = true;
			}
			res++;
			
			int zero = 0;
			for(int i=0; i<N; i++) {
				if(belt[i] == 0) zero++;
			}
			if(zero>=K) break;
		}

		System.out.println(res);
	}
}
