import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int i = Integer.parseInt(st.nextToken()); // c 7
		int j = Integer.parseInt(st.nextToken()); // r 6
		int num = Integer.parseInt(br.readLine());

		if (num > i * j) {
			System.out.println(0);
			return;
		}

		int nr = 1;
		int nc = 1;

		int rMin = 1;
		int cMin = 1;

		// 상 우 하 좌
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int d = 0;
		for (int n = 0; n < num - 1; n++) {
			nr += dr[d % 4];
			nc += dc[d % 4];
			if (!(nr >= rMin && nr <= i && nc >= cMin && nc <= j)) {
				nr -= dr[d % 4];
				nc -= dc[d % 4];
				d++;
				nr += dr[d % 4];
				nc += dc[d % 4];
				if (d % 4 == 3) {
					rMin++;
				}
				if (d / 4 > 0) {
					if (d%4 == 0) {
						j--;
					} else if (d%4 == 1) {
						i--;
					} else if (d%4 == 2) {
						cMin++;
					}
				}
			}
		}
        System.out.println(nr+" "+nc);
	}
}