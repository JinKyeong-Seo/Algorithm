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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] check = new boolean[N][M]; 
        for(int r=0; r<N; r++) {
            String str = br.readLine();
            for(int c=0; c<M; c++) {
                arr[r][c] = str.charAt(c)-'1';
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<miro> queue = new LinkedList<>();
        
        queue.add(new miro(0, 0));
        arr[0][0] = 1;
		while(!queue.isEmpty()) {
        	for(int d=0; d<4; d++) {
        		int nr = queue.peek().r+dr[d];
        		int nc = queue.peek().c+dc[d];
        		if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==0) {
        			arr[nr][nc] = arr[queue.peek().r][queue.peek().c]+1;
        			queue.add(new miro(nr, nc));
        		}
        	}
        	queue.poll();
        }
		
		System.out.println(arr[N-1][M-1]);
    }
}
