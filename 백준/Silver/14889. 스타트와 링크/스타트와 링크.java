import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] visited;
    static int N, min;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int now = Integer.parseInt(st.nextToken());
                arr[r][c] += now;
                arr[c][r] += now;
            }
        }

        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        makeTeam(0, 0);
        System.out.println(min);
    }

    public static void makeTeam(int idx, int sidx) {
        if(sidx==N/2) {
            int yes = 0;
            int no = 0;
            int[] select = new int[N/2];
            int[] noSelect = new int[N/2];
            for(int i=0; i<N; i++) {
                if(visited[i]) {
                    select[yes++] = i;
                } else {
                    noSelect[no++] = i;
                }
            }
            calcPoint(select, noSelect);
            return;
        }

        for(int i=idx; i<=N/2+sidx; i++) {
            visited[i] = true;
            makeTeam(i+1, sidx+1);
            visited[i] = false;
        }
    }

    public static void calcPoint(int[] teamA, int[] teamB) {
        int start = 0;
        int link = 0;
        for(int i=0; i<N/2-1; i++) {
            for(int j=i+1; j<N/2; j++) {
                start += arr[teamA[i]][teamA[j]];
                link += arr[teamB[i]][teamB[j]];
            }
        }
        min = Math.min(min, Math.abs(start-link));
    }
}
