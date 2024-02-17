import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[1002][1002];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int x=r; x<r+w; x++) {
				for(int y=c; y<c+h; y++) {
					paper[x][y] = i;
				}
			}
		}
		
		int[] num = new int[N+1];
		for(int r=0; r<1001; r++) {
			for(int c=0; c<1001; c++) {
				num[paper[r][c]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(num[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
