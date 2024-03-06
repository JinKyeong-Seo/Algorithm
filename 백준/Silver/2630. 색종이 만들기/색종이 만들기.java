import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, prev;
	static int[] res = new int[2];
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		check(N, 0, 0);
		System.out.println(res[0]+"\n"+res[1]);
	}
	static int check(int n, int r, int c) {
		prev = arr[r][c];
		for(int row=r; row<r+n; row++) {
			for(int col=c; col<c+n; col++) {
				if(arr[row][col]!=prev) {
					int half = n/2;
					check(half, r, c);
					check(half, r, c+half);
					check(half, r+half, c);
					check(half, r+half, c+half);
					return 0;
				}
			}
		}
		
		return res[prev]++;
		
	}
}
