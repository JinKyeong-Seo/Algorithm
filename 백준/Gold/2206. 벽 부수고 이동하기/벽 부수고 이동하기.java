import java.io.*;
import java.util.*;

class Person{
    int r, c, w;

    Person(int r, int c, int w){
        this.r = r;
        this.c = c;
        this.w = w;
    }
}

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] check = new int[2][N][M];
        for(int r=0; r<N; r++) {
            String str = br.readLine();
            for(int c=0; c<M; c++) {
                map[r][c] = str.charAt(c)-'0';
            }
        }
        
        // 상좌하우
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(0, 0, 0));
        check[0][0][0] = 1;
        out :while(!queue.isEmpty()) {
            Person now = queue.poll();
            for(int d=0; d<4; d++) {
                int nr = now.r+dr[d];
                int nc = now.c+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M) {
                	if(now.w==0 && map[nr][nc]==0 && check[0][nr][nc]==0) {
                		queue.add(new Person(nr, nc, 0));
                		check[0][nr][nc] = check[0][now.r][now.c]+1;
                	} else if (now.w==0 && map[nr][nc]==1 && check[0][nr][nc]==0) {
                		queue.add(new Person(nr, nc, 1));
                		check[1][nr][nc] = check[0][now.r][now.c]+1;
                	} else if (now.w==1 && map[nr][nc]==0 && check[1][nr][nc]==0){
                		queue.add(new Person(nr, nc, 1));
                		check[1][nr][nc] = check[1][now.r][now.c]+1;
                	}                    
                }
                if(check[0][N-1][M-1]!=0 || check[1][N-1][M-1]!=0) break out;
            }
        }
        
        int res = Math.max(check[0][N-1][M-1], check[1][N-1][M-1]);
        if(res==0) res = -1;
        System.out.println(res);
    }
}