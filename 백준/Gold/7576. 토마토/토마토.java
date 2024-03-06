import java.io.*;
import java.util.*;
class tomato{
	int r;
	int c;
	
	tomato(int r, int c){
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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean check = true;
        Queue<tomato> queue = new LinkedList<>();
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==0) check=false;
                if(arr[r][c]==1) queue.add(new tomato(r, c));
            }
        }
        if(check) {
        	System.out.println(0);
        	return;
        }
        
        int cnt = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
		while(!queue.isEmpty()) {
        	for(int d=0; d<4; d++) {
        		int nr = queue.peek().r+dr[d];
        		int nc = queue.peek().c+dc[d];
        		if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==0) {
        			arr[nr][nc] = arr[queue.peek().r][queue.peek().c]+1;
        			cnt = Math.max(cnt, arr[nr][nc]);
        			queue.add(new tomato(nr, nc));
        		}
        	}
        	queue.poll();
        }
        
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(arr[r][c]==0) {
                	System.out.println(-1);
                	return;
                }
            }
        }
        
        System.out.println(cnt-1);
    }
}
