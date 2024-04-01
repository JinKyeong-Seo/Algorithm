import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E, W;
	static int[] building, degree, memo;
	static List<Integer>[] adjList;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			building = new int[V+1];
			memo = new int[V+1];
			for(int i=1; i<=V; i++) {
				building[i] = Integer.parseInt(st.nextToken());
				memo[i] = building[i];
			}
			
			adjList = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			degree = new int[V+1];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				adjList[A].add(B);
				degree[B]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			queue = new LinkedList<>();
			for(int i=1; i<=V; i++) {
				if(degree[i]==0) queue.add(i);
			}
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(now==W) break;
				for(int e : adjList[now]) {
					degree[e]--;
					if(degree[e]==0) queue.add(e);
					if(memo[e]<building[e]+memo[now]) memo[e] = building[e]+memo[now];
				}
			}
			
			sb.append(memo[W]).append("\n");
		}
		System.out.println(sb);
	}
}
