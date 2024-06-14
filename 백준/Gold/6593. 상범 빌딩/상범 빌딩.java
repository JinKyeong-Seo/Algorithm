import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, R, C;
	static char[][][] building;
	static int[][][] check;
	static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0) break;
			
			building = new char[L][R][C];
			check = new int[L][R][C];
			queue = new LinkedList<>();
			for(int l=0; l<L; l++) {
				for(int r=0; r<R; r++) {
					String str = br.readLine();
					for(int c=0; c<C; c++) {
						building[l][r][c] = str.charAt(c);
						if(building[l][r][c]=='S') {
							queue.add(new int[] {l, r, c});
							check[l][r][c] = 1;
						}
					}
				}
				br.readLine();
			} // 입력 끝
			
			bfs();			
		}
		System.out.println(sb);
	}
	
	static public void bfs() {
		int[] dl = {0, 0, 0, 0, -1, 1};
		int[] dr = {-1, 1, 0, 0, 0, 0};
		int[] dc = {0, 0, -1, 1, 0, 0};
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(building[now[0]][now[1]][now[2]]=='E') {
				sb.append("Escaped in ").append(check[now[0]][now[1]][now[2]]-1).append(" minute(s).\n");
				return;
			}
			
			for(int d=0; d<6; d++) {
				int nl = now[0]+dl[d];
				int nr = now[1]+dr[d];
				int nc = now[2]+dc[d];
				if(nl>=0 && nl<L && nr>=0 && nr<R && nc>=0 && nc<C && check[nl][nr][nc]==0 && building[nl][nr][nc]!='#') {
					queue.add(new int[] {nl, nr, nc});
					check[nl][nr][nc] = check[now[0]][now[1]][now[2]]+1;
				}
			}
		}
		sb.append("Trapped!\n");
	}
}
