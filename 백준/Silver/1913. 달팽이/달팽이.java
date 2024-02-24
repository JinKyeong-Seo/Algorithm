import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		int nr = 0, nc = 0, targetR = 0, targetC = 0;
		int d = 0, num = N*N;
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		while (num!=0) {
			while (0 <= nr && nr < N && 0 <= nc && nc < N && arr[nr][nc] == 0) {
				if(num==target) {
					targetR = nr+1; targetC = nc+1;
				}
				arr[nr][nc] = num--;
				nr += dr[d];
				nc += dc[d];
			}
			nr -= dr[d];
			nc -= dc[d];
			d = (d+1)%4;
			nr += dr[d];
			nc += dc[d];
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(arr[r][c]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(targetR).append(" ").append(targetC);
		
		System.out.println(sb);
	}
}
