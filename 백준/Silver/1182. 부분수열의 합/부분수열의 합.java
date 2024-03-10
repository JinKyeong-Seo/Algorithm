import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr, sel;
	static int N, S, cnt;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			sel = new int[i];
			comb(i, 0, 0);
		}
		
		System.out.println(cnt);
	}
	private static void comb(int i, int idx, int sidx) {
		if(sidx==i) {
			int sum = 0;
			for(int s=0; s<i; s++) {
				sum+=sel[s];
			}
			if(sum==S) cnt++;
			return;
		}

		for(int c=idx; c<=N-i+sidx; c++) {
			sel[sidx] = arr[c];
			comb(i, c+1, sidx+1);
		}
	}
}
