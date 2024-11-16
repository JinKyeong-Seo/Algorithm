import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        st = new StringTokenizer(br.readLine());
        int[] now = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] target = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        arr[now[0]][now[1]]=1;

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(now);
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int d=0; d<6; d++){
                int nr = temp[0]+dr[d];
                int nc = temp[1]+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && arr[nr][nc]==0){
                    queue.add(new int[]{nr, nc});
                    arr[nr][nc] = arr[temp[0]][temp[1]]+1;
                }
            }

            if(arr[target[0]][target[1]]!=0) break;
        }

        System.out.println(arr[target[0]][target[1]]-1);
    }
}
