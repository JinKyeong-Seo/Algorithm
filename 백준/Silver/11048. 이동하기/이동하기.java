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
		
		int[][] miro = new int[N][M];
		int[][] res = new int[N][M];
		boolean[][] check = new boolean[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				miro[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int[] dr = {1, 0, 1};
		int[] dc = {0, 1, 1};
		res[0][0] = miro[0][0];
		queue.add(new int[] {0, 0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<3; d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M ) {
					if(res[nr][nc]<res[now[0]][now[1]]+miro[nr][nc]) {
						res[nr][nc] = res[now[0]][now[1]]+miro[nr][nc];
					}
					if(!check[nr][nc]) {
						queue.add(new int[] {nr, nc});
						check[nr][nc] = true;
					}
					
				}
			}
		}
		
		System.out.println(res[N-1][M-1]);
	}
}
