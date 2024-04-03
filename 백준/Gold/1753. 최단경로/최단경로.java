import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<int[]>[] adjList = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());			
			adjList[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[K] = 0;
		pq.add(new int[] {K, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(visited[now[0]]) continue;
			
			visited[now[0]] = true;
			for(int[] e : adjList[now[0]]) {
				if(!visited[e[0]] && dist[now[0]]+e[1]<dist[e[0]]) {
					dist[e[0]] = dist[now[0]]+e[1];
					pq.add(new int[] {e[0], dist[e[0]]});
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if (dist[i]==INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}
