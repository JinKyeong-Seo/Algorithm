
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, P, cnt, count;
    static int[] dr, dc;
    static int[][] arr, check;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        P = 1;
        cnt = N*M;
        ArrayList<int[]> list = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (0 < arr[r][c] && arr[r][c] < 6) {
                    list.add(new int[] { arr[r][c], r, c });
                    P*=4;
                    cnt--;
                }
                if(arr[r][c]==6) cnt--;
            }
        }
        
        dr = new int[] { -1, 0, 1, 0 };
        dc = new int[] { 0, -1, 0, 1 };
        
        int min = Integer.MAX_VALUE;
        for(int p=0; p<P; p++) {
        	check = new int[N][M];
            for (int i = 0; i < N; i++) {
                check[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
        	count = cnt;
        	int order = p;
            for(int i=0; i<list.size(); i++) {
                int[] now = list.get(i);
                delta(now[0], now[1], now[2], order%4);
                order/=4;
            }
            min = Math.min(count, min);
        }
        
        System.out.println(min);
    }

    static public void delta(int n, int r, int c, int d) {
        if (n == 1) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] != 6) {
                if (check[nr][nc] == 0) {
                	check[nr][nc] = 7;
                	count--;
                }
                nr += dr[d];
                nc += dc[d];
            }
        } else if (n == 2) {
        	int[] idx = new int[] {d, (d+2)%4};
        	for(int i=0; i<2; i++) {
        		int nr = r + dr[idx[i]];
        		int nc = c + dc[idx[i]];
        		while (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] != 6) {
        			if (check[nr][nc] == 0) {
        				check[nr][nc] = 7;
        				count--;
        			}
        			nr += dr[idx[i]];
        			nc += dc[idx[i]];
        		}
        	}
        } else if (n == 3) {
        	int[] idx = new int[] {d, (d+1)%4};
        	for(int i=0; i<2; i++) {
        		int nr = r + dr[idx[i]];
        		int nc = c + dc[idx[i]];
        		while (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] != 6) {
        			if (check[nr][nc] == 0) {
        				check[nr][nc] = 7;
        				count--;
        			}
        			nr += dr[idx[i]];
        			nc += dc[idx[i]];
        		}
        	}

        } else if (n == 4) {
        	int[] idx = new int[] {d, (d+1)%4, (d+2)%4};
        	for(int i=0; i<3; i++) {
        		int nr = r + dr[idx[i]];
        		int nc = c + dc[idx[i]];
        		while (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] != 6) {
        			if (check[nr][nc] == 0) {
        				check[nr][nc] = 7;
        				count--;
        			}
        			nr += dr[idx[i]];
        			nc += dc[idx[i]];
        		}
        	}
        } else {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                while (nr >= 0 && nr < N && nc >= 0 && nc < M && check[nr][nc] != 6) {
                    if (check[nr][nc] == 0) {
                    	check[nr][nc] = 7;
                    	count--;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }
    }
}