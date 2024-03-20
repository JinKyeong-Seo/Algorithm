import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] labtop, sticker, tmpST;
	static int N, M, W, H;
	static boolean success;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		labtop = new int[N][M];

		next: for (int k = 0; k < K; k++) {
			success = false;
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			sticker = new int[W][H];
			for (int r = 0; r < W; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < H; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int d=0; d<4; d++) {
				rotation(d);
				if (N-W<0 || M-H<0) continue;
				for (int sr = 0; sr <= N-W; sr++) {
					for (int sc = 0; sc <= M-H; sc++) {
						check(sr, sc);
						if (success) continue next;			
					}
				}
			}
		}

		int res = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (labtop[r][c] == 1)
					res++;
			}
		}
		System.out.println(res);
	}

	static public void rotation(int d) {
		if (d == 0) {
			return;
		} else  {
			tmpST = new int[H][W];
			for (int i = 0; i < H; i++) { 
				for (int j = 0; j < W; j++) { 
					tmpST[i][j] = sticker[W-1-j][i];
				}
			}
		}
		sticker = tmpST;
		W = tmpST.length;
		H = tmpST[0].length;
	}

	static public void check(int r, int c) {		
		for (int i = r; i < r + W; i++) {
			for (int j = c; j < c + H; j++) {
				if (sticker[i - r][j - c] == 1 && labtop[i][j] == 1) return;
			}
		}

		for (int i = r; i < r + W; i++) {
			for (int j = c; j < c + H; j++) {
				if (sticker[i - r][j - c] == 1)
					labtop[i][j] = 1;
			}
		}
		success = true;
	}
}