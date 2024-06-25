import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] edges;
	static int[] p;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edges = new int[E][2];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		p = new int[V+1];
		for(int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		int group = V;
		for(int i=0; i<E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px!=py) {
				union(px, py);
				group--;
			}
		}
		
		System.out.println(group);
	}
	
	static int findSet(int x) {
		if(x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = p[x];
	}
}
