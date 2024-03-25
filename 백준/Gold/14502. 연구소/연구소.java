import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static List<int[]> list, virus;
    static int[][] sel, arr, tmp;
    static int N, M, res;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        virus = new ArrayList<>();
        sel = new int[3][2];
        arr = new int[N][M];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c]==0) list.add(new int[] {r, c});
                if(arr[r][c]==2) virus.add(new int[] {r, c});
            }
        }
        res = 0;
        comb(0, 0);
        System.out.println(res);
    }
    
    public static void comb(int idx, int sidx) {
    	if(sidx==3) {
    		res = Math.max(res, bfs(sel));
    		return;
    	}
    	
    	for(int i=idx; i<=list.size()-3+sidx; i++) {
    		sel[sidx] = list.get(i);
    		comb(i+1, sidx+1);
    	}
    }
    
    public static int bfs(int[][] sel) {
    	tmp = new int[N][M];
    	for(int i=0; i<N; i++) {
    		tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
    	}
    	for(int i=0; i<3; i++) {
    		int[] now = sel[i];
    		tmp[now[0]][now[1]] = 1;
    	}
    	
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	
    	Queue<int[]> queue = new LinkedList<>();
    	for(int i=0; i<virus.size(); i++) {
    		queue.add(virus.get(i));
    	}
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = now[0]+dr[d];
				int nc = now[1]+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && tmp[nr][nc]==0) {
					queue.add(new int[] {nr, nc});
					tmp[nr][nc] = 2;
				}
			}
		}

    	int sum = 0;
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++) {
    			if(tmp[r][c]==0) sum++;
    		}
    	}
    	return sum;
    }
}