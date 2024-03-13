import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int[] dr, dc;
    static char[][] puyo = new char[12][6];
    static boolean[][] check;
    static Queue<int[]> pang, queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        for(int r=0; r<12; r++) {
            str = br.readLine();
            for(int c=0; c<6; c++) {
                puyo[r][c] = str.charAt(c);
            }
        }
        
        dr = new int[]{-1, 1, 0, 0};
        dc = new int[]{0, 0, -1, 1};   
        
        int res = 0 ;
        while(true) {
        	pang = new LinkedList<>();
            queue = new LinkedList<>();
        	countPang();
        	if(pang.isEmpty()) break;
        	res++;
        	realPang();
        	downPuyo();
        }
        
        System.out.println(res);
    }
    
    static public void countPang() {
        check = new boolean[12][6];
        for(int r=0; r<12; r++) {
            for(int c=0; c<6; c++) {
                if(puyo[r][c]!='.') {
                    queue.add(new int[] {r, c});
                    check[r][c] = true;
                    int cnt = 0;
                    while(!queue.isEmpty()) {
                        cnt++;
                        int[] now = queue.poll();
                        for(int d=0; d<4; d++) {
                            int nr = now[0]+dr[d];
                            int nc = now[1]+dc[d];
                            if(nr>=0 && nr<12 && nc>=0 && nc<6 && !check[nr][nc] && puyo[now[0]][now[1]] == puyo[nr][nc]) {
                                check[nr][nc] = true;
                                queue.add(new int[] {nr, nc});
                            }
                        }
                    }
                    if(cnt>=4) pang.add(new int[] {r, c});
                }
            }
        }
    }
    
    static public void realPang() {
        check = new boolean[12][6];
        while(!pang.isEmpty()) {
            int[] now = pang.poll();
            check[now[0]][now[1]] = true;
            for(int d=0; d<4; d++) {
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr>=0 && nr<12 && nc>=0 && nc<6 && !check[nr][nc] && puyo[now[0]][now[1]] == puyo[nr][nc]) {
                    check[nr][nc] = true;
                    pang.add(new int[] {nr, nc});
                }
            }
            puyo[now[0]][now[1]] = '.';
        }
    }
    
    static public void downPuyo() {
    	for(int c=0; c<6; c++) {
    		for(int r=11; r>=0; r--) {
                if(puyo[r][c]!='.') {
                	int nr = r+1;
                	while(nr<12 && puyo[nr][c]=='.') {
                		char tmp = puyo[nr][c];
                		puyo[nr][c] = puyo[nr-1][c];
                		puyo[nr-1][c] = tmp;
                		nr++;
                	}
                }
            }  
    	}
    }
    
}