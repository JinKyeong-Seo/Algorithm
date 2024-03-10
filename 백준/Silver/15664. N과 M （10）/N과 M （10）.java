import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, sel;
	static int N, M;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		sel = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		check(0, 0);
		System.out.println(sb);
		
	}
	private static void check(int idx, int sidx) {
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		for(int i=idx; i<=N-M+sidx; i++) {
			if(before!=arr[i]) {
				before = arr[i];
				sel[sidx] = arr[i];
				check(i+1, sidx+1);
			}
		}
	}
}
