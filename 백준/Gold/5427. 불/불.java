import java.io.*;
import java.util.*;

class miro{
	int r;
	int c;
	
	miro(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        tc : for(int t=1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int C = Integer.parseInt(st.nextToken());
        	int R = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[R][C];
        	int[][] arr2 = new int[R][C];
        	Queue<miro> queue = new LinkedList<>();
        	Queue<miro> queue2 = new LinkedList<>();
        	for(int r=0; r<R; r++) {
        		String str = br.readLine();
        		for(int c=0; c<C; c++) {
        			arr[r][c] = str.charAt(c);
        			if(arr[r][c]==42) { // *
        				queue.add(new miro(r, c));
        				arr[r][c] = 1;
        				arr2[r][c] = 0;
        			} else if(arr[r][c]==64) { // @
        				queue2.add(new miro(r, c));
        				arr[r][c] = 0;
        				arr2[r][c] = 1;
        			} else if(arr[r][c]==35) { // #
        				arr[r][c] = -1;
        				arr2[r][c] = -1;
        			} else { // .
        				arr[r][c] = 0;
        				arr2[r][c] = 0;
        			}
        		}
        	}
        	
        	int[] dr = {-1, 1, 0, 0};
        	int[] dc = {0, 0, -1, 1};
        	
        	while(!queue.isEmpty()) {
        		miro first = queue.poll();
        		for(int d=0; d<4; d++) {
        			int nr = first.r+dr[d];
        			int nc = first.c+dc[d];
        			if(nr>=0 && nr<R && nc>=0 && nc<C && arr[nr][nc]==0) {
        				arr[nr][nc] = arr[first.r][first.c]+1;
        				queue.add(new miro(nr, nc));
        			}
        		}
        	}
        	
        	while(!queue2.isEmpty()) {
        		miro first = queue2.poll();
        		for(int d=0; d<4; d++) {
        			int nr = first.r+dr[d];
        			int nc = first.c+dc[d];
        			if(nr<0 || nr>=R || nc<0 || nc>=C) {
        				sb.append(arr2[first.r][first.c]).append("\n");
        				continue tc;
        			}
        			if(arr2[nr][nc]==0) {
        				if(arr[nr][nc]==0 || arr[nr][nc]>(arr2[first.r][first.c]+1)) {
        					arr2[nr][nc] = arr2[first.r][first.c]+1;
        					queue2.add(new miro(nr, nc));
        				}
        				else {
        					arr2[nr][nc] = -1;
        				}
        			}
        		}
        	}
        	
        	sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}
