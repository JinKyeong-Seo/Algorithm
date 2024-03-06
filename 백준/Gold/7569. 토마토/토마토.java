import java.io.*;
import java.util.*;

class tomato{
	int h;
	int r;
	int c;
	
	tomato(int h, int r, int c){
		this.h = h;
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
        int H = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[H][N][M];
        boolean check = true;
        Queue<tomato> queue = new LinkedList<>();
        for(int h=0; h<H; h++) {
        	for(int r=0; r<N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<M; c++) {
                    arr[h][r][c] = Integer.parseInt(st.nextToken());
                    if(arr[h][r][c]==0) check=false;
                    if(arr[h][r][c]==1) queue.add(new tomato(h, r, c));
                }
            }
        }
        
        if(check) {
        	System.out.println(0);
        	return;
        }
        
        int cnt = 0;
        int[] dh = {0, 0, 0, 0, -1, 1};
        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {-1, 1, 0, 0, 0, 0};
        
		while(!queue.isEmpty()) {
			tomato first = queue.poll();
        	for(int d=0; d<6; d++) {
        		int nh = first.h+dh[d];
        		int nr = first.r+dr[d];
        		int nc = first.c+dc[d];
        		if(nh>=0 && nh<H && nr>=0 && nr<N && nc>=0 && nc<M && arr[nh][nr][nc]==0) {
        			arr[nh][nr][nc] = arr[first.h][first.r][first.c]+1;
        			cnt = Math.max(cnt, arr[nh][nr][nc]);
        			queue.add(new tomato(nh, nr, nc));
        		}
        	}
        }
        
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
	            for(int c=0; c<M; c++) {
	                if(arr[h][r][c]==0) {
	                	System.out.println(-1);
	                	return;
	                }
	            }
	        }
		}
        
        System.out.println(cnt-1);
    }
}
