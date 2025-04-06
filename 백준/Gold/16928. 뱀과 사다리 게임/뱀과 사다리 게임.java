import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] game, play;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        game = new int[101];

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            game[now] = next-now;
        }

        play = new int[101];
        bfs();
        System.out.println(play[100]-1);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        play[1] = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int n=1; n<=6; n++) {
                int next = now[0] + n;
                if(next > 100) continue;

                next += game[next];
                if(play[next]==0 || play[next] > now[1]+1) {
                    queue.add(new int[]{next, now[1]+1});
                    play[next] = now[1]+1;
                    play[now[0] + n] = now[1]+1;
                }
            }
        }
    }
}
