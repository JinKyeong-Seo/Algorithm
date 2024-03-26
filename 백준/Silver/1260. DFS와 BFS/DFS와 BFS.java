import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] adj;
	static boolean[] check;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B);
			adj[B].add(A);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(adj[i]);
		}
		
		check = new boolean[N+1];
		check[V] = true;
		dfs(V);
		sb.append("\n");
		
		queue = new LinkedList<>();
		queue.add(V);
		check = new boolean[N+1];
		check[V] = true;
		bfs(V);
		System.out.println(sb);
	}
	
	public static void dfs(int v) {
		sb.append(v).append(" ");
		for(int w : adj[v]) {
			if(!check[w]) {
				check[w] = true;
				dfs(w);
			}
		}
	}
	
	public static void bfs(int v) {
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for(int w : adj[now]) {
				if(!check[w]) {
					check[w] = true;
					queue.add(w);
				}
			}
		}
	}
}
