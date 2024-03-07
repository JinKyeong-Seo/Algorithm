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
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			Queue<int[]> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			arr[sr][sc] = 1;
			queue.add(new int[] {sr, sc});
			
			st = new StringTokenizer(br.readLine());
			int gr = Integer.parseInt(st.nextToken());
			int gc = Integer.parseInt(st.nextToken());
			
			int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
			int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
			
			while(arr[gr][gc]==0) {
				int[] now = queue.poll();
				for(int d=0; d<8; d++) {
					int nr = now[0]+dr[d];
					int nc = now[1]+dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && arr[nr][nc]==0) {
						arr[nr][nc] = arr[now[0]][now[1]]+1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
			
			sb.append(arr[gr][gc]-1).append("\n");
		}
		System.out.println(sb);
	}
}
