import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] arr, sel;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		for(int i=0; i<N; i++) {
			arr[i] = list.get(i);
		}
		
		perm(0);
		System.out.println(sb);
		
	}
	static void perm(int sidx) {
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(check[i]) continue;
			check[i] = true;
			sel[sidx] = arr[i];
			perm(sidx+1);
			check[i] = false;
		}
		
	}
}
