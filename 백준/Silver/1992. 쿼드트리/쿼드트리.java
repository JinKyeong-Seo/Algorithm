import java.io.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int N, prev;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				arr[r][c] = str.charAt(c)-'0';
			}
		}
		
		check(N, 0, 0);
		System.out.println(sb);
	}
	static void check(int n, int r, int c) {
		prev = arr[r][c];
		for(int row=r; row<n+r; row++) {
			for(int col=c; col<n+c; col++) {
				if(arr[row][col]!=prev) {
					int half = n/2;
					sb.append("(");
					check(half, r, c);
					check(half, r, c+half);
					check(half, r+half, c);
					check(half, r+half, c+half);
					sb.append(")");
					return;
				}
			}
		}
		
		sb.append(prev);
	}
}
