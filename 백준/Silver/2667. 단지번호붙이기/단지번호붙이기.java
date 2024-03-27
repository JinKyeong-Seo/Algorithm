import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				house[r][c] = str.charAt(c)-'0';
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		List<Integer> list = new ArrayList<>();
		boolean[][] check = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(house[r][c]==1 && !check[r][c]) {
					int sum = 0;
					queue.add(new int[] {r, c});
					check[r][c] = true;
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						sum++;
						for(int d=0; d<4; d++) {
							int nr = now[0]+dr[d];
							int nc = now[1]+dc[d];
							if(nr>=0 && nr<N && nc>=0 && nc<N && house[nr][nc]==1 && !check[nr][nc]) {
								queue.add(new int[] {nr, nc});
								check[nr][nc] = true;
							}
						}
					}
					list.add(sum);
				}
			}
		}
		
		Collections.sort(list);
		int size = list.size();
		sb.append(size).append("\n");
		for(int i=0; i<size; i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}
