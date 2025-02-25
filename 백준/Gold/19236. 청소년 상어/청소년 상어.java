import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] dr, dc;
    static int max;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][4];
        int[][] fish = new int[17][3];
        for(int r=0; r<4; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<4; c++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())-1;
                arr[r][c] = a;
                fish[a] = new int[]{r, c, b};
            }
        }

        dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        dc = new int[]{0, -1, -1, -1, 0, 1, 1, 1};

        max = arr[0][0];
        int[] shark = new int[]{0, 0, fish[max][2]};
        fish[max][2] = -1;
        arr[0][0] = -1;

        dfs(arr, shark, fish, max);
        System.out.println(max);
    }

    public static void dfs(int[][] arr, int[] shark, int[][] fish, int sum) {
        max = Math.max(max, sum);

        moveFish(arr, fish);

        for(int d=1; d<4; d++) {
            int nr = shark[0] + dr[shark[2]]*d;
            int nc = shark[1] + dc[shark[2]]*d;

            if(nr >=0 && nr < 4 && nc>=0 && nc<4 && arr[nr][nc]!=0) {
                int[][] nextArr = copyArray(arr);
                int[][] nextFish = copyFish(fish);

                int target = arr[nr][nc];

                nextArr[shark[0]][shark[1]] = 0;
                nextArr[nr][nc] = -1;

                int[] nextShark = new int[]{nr, nc, fish[target][2]};
                nextFish[target][2] = -1;

                dfs(nextArr, nextShark, nextFish, sum + target);
            }
        }
    }

    public static void moveFish(int[][] arr, int[][] fish) {
        for(int f=1; f<=16; f++) {
            if(fish[f][2]==-1) continue;
            int[] now = fish[f];
            for(int d=0; d<8; d++) {
                int nd = (now[2]+d)%8;
                int nr = now[0] + dr[nd];
                int nc = now[1] + dc[nd];
                if(nr >=0 && nr < 4 && nc>=0 && nc < 4 && arr[nr][nc] != -1) {
                    int number = arr[nr][nc];

                    fish[f] = new int[]{nr, nc, nd};
                    arr[now[0]][now[1]] = number;
                    arr[nr][nc] = f;

                    if(number!=0) {
                        fish[number][0] = now[0];
                        fish[number][1] = now[1];
                    }
                    break;
                }
            }
        }
    }

    static int[][] copyArray(int[][] arr) {
        int[][] newArr = new int[4][4];

        for(int r=0; r<4; r++) {
            for(int c=0; c<4; c++) {
                newArr[r][c] = arr[r][c];
            }
        }
        return newArr;
    }

    static int[][] copyFish(int[][] fish) {
        int[][] newFish = new int[17][3];

        for(int r=1; r<=16; r++) {
            for(int c=0; c<3; c++) {
                newFish[r][c] = fish[r][c];
            }
        }
        return newFish;
    }
}
