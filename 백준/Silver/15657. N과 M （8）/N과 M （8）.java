import java.io.*;
import java.util.*;

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
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = list.get(i);
		}
		
		sel = new int[M];
		comb(0, 0);
		System.out.println(sb);
	}
	static void comb(int idx, int sidx) {
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<N; i++) {
			sel[sidx] = arr[i];
			comb(i, sidx+1);
		}
		
	}
}
