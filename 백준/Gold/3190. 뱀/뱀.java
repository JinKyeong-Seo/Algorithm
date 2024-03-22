import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] board, apples;
    static int res, r, c, nr, nc, seconds, d, L;
    static char direct;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        seconds = Integer.parseInt(st.nextToken());
        direct = st.nextToken().charAt(0);
        d = 0;
        board[0][0] = 2;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int[] head = new int[] {0, 1};
        int[] tail = new int[2];
        Queue<int[]> queue = new LinkedList<>();
        while(head[0]>=0 && head[0]<N && head[1]>=0 && head[1]<N && board[head[0]][head[1]]<=1) {
        	queue.add(new int[] {head[0], head[1]});
            res++;
            if(board[head[0]][head[1]]==0) {
                board[tail[0]][tail[1]] = 0;
                tail = queue.poll();
            }
            board[head[0]][head[1]] = 2;
            if(res == seconds) {
                if(L>0) direction();
            }
            head[0]+=dr[d];
            head[1]+=dc[d];
        }
        System.out.println(res+1);
    }

    static public void direction() throws IOException {
        L--;
        if(direct=='L') {
            d = (d-1+4)%4;
        } else {
            d = (d+1)%4;
        }
        if(L>0) {
            st = new StringTokenizer(br.readLine());
            seconds = Integer.parseInt(st.nextToken());
            direct = st.nextToken().charAt(0);
        }
    }
}