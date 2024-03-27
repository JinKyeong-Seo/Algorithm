import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][3];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				cost[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] house = new int[N][3];
		house[0][0] = cost[0][0];
		house[0][1] = cost[0][1];
		house[0][2] = cost[0][2];
		for(int i=1; i<N; i++) {
			house[i][0] = Math.min(house[i-1][1], house[i-1][2])+cost[i][0];
			house[i][1] = Math.min(house[i-1][0], house[i-1][2])+cost[i][1];
			house[i][2] = Math.min(house[i-1][0], house[i-1][1])+cost[i][2];
		}
		
		System.out.println(Math.min(house[N-1][0], Math.min(house[N-1][1],house[N-1][2])));
	}
}
