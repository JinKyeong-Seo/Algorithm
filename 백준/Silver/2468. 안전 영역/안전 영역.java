import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> queue;
	static boolean[][] check;
	static int[][] region;
	static int[] dr, dc;
	static int N;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		region = new int[N][N];
		int height = 1;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				region[r][c] = Integer.parseInt(st.nextToken());
				height = Math.max(height, region[r][c]);
			}
		}
		
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		
		int max = 1;
		queue = new LinkedList<>();
		for(int h=1; h<=height; h++) {
			check = new boolean[N][N];
			int sum = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(region[r][c]>h && !check[r][c]) {
						sum++;
						queue.add(new int[] {r, c});
						check[r][c] = true;
						bfs(h);
					}
				}
			}
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
	
	public static void bfs(int h) {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !check[nr][nc] && region[nr][nc]>h) {
					queue.add(new int[] {nr, nc});
					check[nr][nc] = true;
				}
			}
		}
	}
}
