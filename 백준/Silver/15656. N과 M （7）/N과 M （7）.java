import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, sel;
	static int N, M;
	public static void main(String[] args) throws IOException {
		br=  new BufferedReader(new InputStreamReader(System.in));
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
		sel = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = list.get(i);
		}
		
		perm(0);
		System.out.println(sb);
	}
	static void perm(int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			sel[idx] = arr[i];
			perm(idx+1);
		}
	}
}
