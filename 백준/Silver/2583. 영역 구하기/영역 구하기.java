import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int oneX = Integer.parseInt(st.nextToken());
			int oneY = Integer.parseInt(st.nextToken());
			int twoX = Integer.parseInt(st.nextToken());
			int twoY = Integer.parseInt(st.nextToken());
			for(int r=oneX; r<twoX; r++) {
				for(int c=oneY; c<twoY; c++) {
					arr[r][c] = 1;
				}
			}
			
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		List<Integer> list = new ArrayList<>();
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] check = new boolean[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(arr[r][c]==0 && !check[r][c]) {
					int sum = 0;
					queue.add(new int[] {r, c});
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						check[r][c] = true;
						sum++;
						for(int d=0; d<4; d++) {
							int nr = now[0]+dr[d];
							int nc = now[1]+dc[d];
							if(nr>=0 && nr<N && nc>=0 && nc<M && !check[nr][nc] && arr[nr][nc]==0) {
								queue.add(new int[] {nr, nc});
								check[nr][nc] = true;
							}
						}
					}
					list.add(sum);
				}
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
}
