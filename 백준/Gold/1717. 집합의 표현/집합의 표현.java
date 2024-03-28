import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] p;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(type==0) {
				union(x, y);
			} else {
				int px = findSet(x);
				int py = findSet(y);
				if(px==py) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static int findSet(int x) {
		if(x!=p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = p[findSet(x)];
	}
}