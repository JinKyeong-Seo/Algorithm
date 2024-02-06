import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] paper = new int[102][102];
		int res = 0;

		// 배열
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int rs = Integer.parseInt(st.nextToken())+1;
			int cs = Integer.parseInt(st.nextToken())+1;
			for (int r = rs; r <= rs + 9; r++) {
				for (int c = cs; c <= cs + 9; c++) {
					if (r == rs || r == rs + 9 || c == cs || c == cs + 9) {
						paper[r][c] = 2;
					} else {
						paper[r][c] = 1;
					}
				}
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		for (int r = 0; r < 102; r++) {
			for (int c = 0; c < 102; c++) {
				if (paper[r][c] == 2) {
					int zero = 0;
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(paper[nr][nc]==0) {
							zero++;
						}
					}
					res+=zero;
				}
			}
		}
		System.out.println(res);
	}
}