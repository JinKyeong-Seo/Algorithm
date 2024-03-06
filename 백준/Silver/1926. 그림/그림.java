import java.io.*;
import java.util.*;

class picture{
	int r;
	int c;
	
	picture(int r, int c){
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] check = new boolean[N][M]; 
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<picture> queue = new LinkedList<>();
        
        int max = 0;
        int cnt = 0;
        for(int r=0; r<N; r++) {
        	for(int c=0; c<M; c++) {
        		if(!check[r][c] && arr[r][c]==1) {
        			cnt++;
        			int size = 0;
        			check[r][c] = true;
        			queue.add(new picture(r, c));
        			while(!queue.isEmpty()) {
        	        	for(int d=0; d<4; d++) {
        	        		int nr = queue.peek().r+dr[d];
        	        		int nc = queue.peek().c+dc[d];
        	        		if(nr>=0 && nr<N && nc>=0 && nc<M && !check[nr][nc] && arr[nr][nc]==1) {
        	        			check[nr][nc] = true;
        	        			queue.add(new picture(nr, nc));
        	        		}
        	        	}
        	        	queue.poll();
        	        	size++;
        	        }
        			max = Math.max(max, size);
        		}
        	}
        }
        
        System.out.println(cnt);
        System.out.println(max);
    }
}