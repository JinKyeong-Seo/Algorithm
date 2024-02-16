import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int[] black, white;
	static int N, M, min;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		min = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			String text = br.readLine();
			for (int c = 0; c < M; c++) {
				board[r][c] = text.charAt(c) == 'B' ? -1 : 1;
			}
		}
		black = new int[] { -1, 1, -1, 1, -1, 1, -1, 1 };
		white = new int[] { 1, -1, 1, -1, 1, -1, 1, -1 };
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				min = Math.min(min, check(r, c));
			}
		}
		System.out.println(min);

	}

	static int check(int r, int c) {
		int cntB=0, cntW=0;
		for (int i = r; i < r+8; i++) {
			for (int j = c; j < c+8; j++) {
				if((i-r)%2==0) {
					if(board[i][j] != black[j-c]) {
						cntB++;
					}
					if(board[i][j] != white[j-c]) {
						cntW++;
					}
				} else {
					if(board[i][j] != white[j-c]) {
						cntB++;
					}
					if(board[i][j] != black[j-c]) {
						cntW++;
					}
				}
			}
		}
		return Math.min(cntB, cntW);
	}
}