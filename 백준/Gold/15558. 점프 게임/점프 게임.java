import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static boolean[][] arr, visited;
    static int N, K;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[2][N];
        visited = new boolean[2][N];
        String left = br.readLine();
        String right = br.readLine();
        for(int n=0; n<N; n++) {
            arr[0][n] = left.charAt(n) == '1';
            arr[1][n] = right.charAt(n) == '1';
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int[] dl = {0, 0, 1};
        int[] di = {1, -1, K};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // LR, idx, time

        int success = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int d=0; d<3; d++) {
                int nl = (now[0]+dl[d])%2;
                int ni = now[1]+di[d];

                if(ni >= N) {
                    success = 1;
                    break;
                }

                if(ni >=0 && arr[nl][ni] && ni > now[2] && !visited[nl][ni]) {
                    visited[nl][ni] = true;
                    queue.add(new int[]{nl, ni, now[2]+1});
                }
            }
        }

        return success;
    }
}
