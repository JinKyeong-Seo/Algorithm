import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			
			Queue<int[]> queue = new LinkedList<>();
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[r][c]=1;
			}
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			int cnt = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(arr[r][c]==1) {
						cnt++;
						queue.add(new int[] {r, c});
						while(!queue.isEmpty()) {
							int[] prev = queue.poll();
							for(int d=0; d<4; d++) {
								int nr = prev[0]+dr[d];
								int nc = prev[1]+dc[d];
								if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==1) {
									arr[nr][nc] = 2;
									queue.add(new int[] {nr, nc});
								}
							}
						}
					}
				}
			}
			
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
