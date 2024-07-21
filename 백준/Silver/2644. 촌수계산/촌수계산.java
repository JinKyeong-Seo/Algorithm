import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] adjArr;
	static boolean[] check;
	static int N, res;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		adjArr = new int[N+1][N+1];
		check = new boolean[N+1];// 입력 끝
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			adjArr[s][p] = 1;
			adjArr[p][s] = 1;
		}
		
		res = -1;
		dfs(A, B, 0);
		System.out.println(res);
	}
	
	public static void dfs(int A, int B, int cnt) {
		if(A==B) {
			res = cnt;
			return;
		}
		
		check[A] = true;
		for(int i=1; i<=N; i++) {
			if(adjArr[A][i]==1 && !check[i]) {
				dfs(i, B, cnt+1);
			}
		}
	}
}
