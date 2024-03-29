
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] road, res;
    static boolean[][] check;
    static Queue<int[]> queue;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        int N = Integer.parseInt(br.readLine());
        while(N!=0) {
        	road = new int[N][N];
        	check = new boolean[N][N];
        	res = new int[N][N];
        	for(int r=0; r<N; r++) {
        		st = new StringTokenizer(br.readLine());
        		for(int c=0; c<N; c++) {
        			road[r][c] = Integer.parseInt(st.nextToken());
        			res[r][c] = INF;
        		}
        	}
        	
        	int[] dr = {-1, 1, 0, 0};
        	int[] dc = {0, 0, 1, -1};
        	
        	res[0][0] = 0;
        	queue = new LinkedList<>();
        	queue.add(new int[] {0, 0});
        	while(!queue.isEmpty()) {
        		int[] now = queue.poll();
        		for(int d=0; d<4; d++) {
        			int nr = now[0]+dr[d];
        			int nc = now[1]+dc[d];
        			if(nr>=0 && nr<N && nc>=0 && nc<N) {
        				if(res[nr][nc] > res[now[0]][now[1]]+road[nr][nc]) {
        					res[nr][nc] = res[now[0]][now[1]]+road[nr][nc];
        					queue.add(new int[] {nr, nc});
        				}
        			}
        		}
        	}
        	sb.append("Problem ").append(t++).append(": ").append(res[N-1][N-1]+road[0][0]).append("\n");
        	N = Integer.parseInt(br.readLine());
        }
        
        System.out.println(sb);
    }
}
