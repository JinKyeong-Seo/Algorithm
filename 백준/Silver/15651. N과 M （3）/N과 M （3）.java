import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] arr, sel;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= IntStream.range(1, N+1).toArray();
		sel = new int[M];
		
		comb(0);
		System.out.println(sb);
		
	}
	static void comb(int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			sel[idx] = arr[i];
			comb(idx+1);
		}
	}
}
