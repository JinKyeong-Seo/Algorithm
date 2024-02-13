import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>() {
            {
                put("R", 0);
                put("L", 1);
                put("B", 2);
                put("T", 3);
                put("RT", 4);
                put("LT", 5);
                put("RB", 6);
                put("LB", 7);
            }
        };
        // 우 좌 하 상 우상 좌상 우하 좌하
        int[] dr = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
        int rockR = rock.charAt(1)-'1'+1; // A1 0,0
        int rockC = rock.charAt(0)-'A';
        int nr = king.charAt(1)-'1'+1;
        int nc = king.charAt(0)-'A';

        for(int i=0; i<N; i++) {
            int move = map.get(br.readLine());
            if(!((nr+dr[move])<1 || (nr+dr[move])>8 || (nc+dc[move])<0 || (nc+dc[move])>7)) {
                nr += dr[move];
                nc += dc[move];
                if(nr == rockR && nc == rockC) {
                    if((rockR+dr[move])<1 || (rockR+dr[move])>8 || (rockC+dc[move])<0 || (rockC+dc[move])>7) {
                        nr -= dr[move];
                        nc -= dc[move];
                        continue;
                    }
                    rockR += dr[move];
                	rockC += dc[move];
                }
            }
        }
        System.out.println(Character.toString('A'+nc)+nr);
        System.out.println(Character.toString('A'+rockC)+rockR);
    }
}