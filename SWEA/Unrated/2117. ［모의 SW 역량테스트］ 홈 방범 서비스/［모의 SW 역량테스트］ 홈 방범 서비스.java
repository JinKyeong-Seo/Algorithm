import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            boolean[][] check;
            for(int r=0; r<N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }                
            }
             
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            int max = 1;
            
            for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) {
        			int sum = arr[r][c];
        			int k = 1;
        			check = new boolean[N][N];
        			Queue<int[]> home = new LinkedList<>();
        			home.add(new int[] {r, c});
        			while(!home.isEmpty()) {
        				if(sum*M-(k*k+(k-1)*(k-1))>=0) {
        					max = Math.max(max, sum);                		
        				}
        				int cnt = home.size();
        				for(int i=0; i<cnt; i++) {
        					int[] now = home.poll();
        					check[now[0]][now[1]] = true;
        					for(int d=0; d<4; d++) {
        						int nr = now[0]+dr[d];
        						int nc = now[1]+dc[d];
        						if(nr>=0 && nr<N && nc>=0 && nc<N && !check[nr][nc]) {
        							home.add(new int[] {nr, nc});
        							if(arr[nr][nc]==1) sum++;
        							check[nr][nc] = true;
        						}
        					}
        				}
        				k++;
        			}
            	}
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}