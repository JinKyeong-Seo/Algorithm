import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, sel;
	static boolean[] check;
	static int N, M, before;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		sel = new int[M];
		check = new boolean[N];
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int sidx) {
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");

			return;
		}
		int before = 0;
		for(int i=0; i<N; i++) {
			if(before!=arr[i] && !check[i]) {
				check[i] = true;
				sel[sidx] = arr[i];
				before = arr[i];
				perm(sidx+1);
				check[i] = false;
			}
		}
	}
}
