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
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];
        int[][] arr2 = new int[R][C];
        Queue<miro> queue = new LinkedList<>();
        Queue<miro> queue2 = new LinkedList<>();
        for(int r=0; r<R; r++) {
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                arr[r][c] = str.charAt(c);
                if(arr[r][c]==70) { // F
                	queue.add(new miro(r, c));
                	arr[r][c] = 1;
                	arr2[r][c] = 0;
                } else if(arr[r][c]==74) { // J
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
        	for(int d=0; d<4; d++) {
        		int nr = queue.peek().r+dr[d];
        		int nc = queue.peek().c+dc[d];
        		if(nr>=0 && nr<R && nc>=0 && nc<C && arr[nr][nc]==0) {
        			arr[nr][nc] = arr[queue.peek().r][queue.peek().c]+1;
        			queue.add(new miro(nr, nc));
        		}
        	}
        	queue.poll();
        }
		
		while(!queue2.isEmpty()) {
        	for(int d=0; d<4; d++) {
        		int nr = queue2.peek().r+dr[d];
        		int nc = queue2.peek().c+dc[d];
        		if(nr<0 || nr>=R || nc<0 || nc>=C) {
        			System.out.println(arr2[queue2.peek().r][queue2.peek().c]);
        			return;
        		}
        		if(arr2[nr][nc]==0) {
        			if(arr[nr][nc]==0 || arr[nr][nc]>(arr2[queue2.peek().r][queue2.peek().c]+1)) {
        				arr2[nr][nc] = arr2[queue2.peek().r][queue2.peek().c]+1;
        				queue2.add(new miro(nr, nc));
        			}
        			else {
        				arr2[nr][nc] = -1;
        			}
        		}
        	}
        	queue2.poll();
        }
		
		System.out.println("IMPOSSIBLE");
    }
}
