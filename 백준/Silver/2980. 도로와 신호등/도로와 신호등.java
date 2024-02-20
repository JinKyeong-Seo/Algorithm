import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] light;
	static int[] signal, rg;
	static int N, L, sec;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		signal = new int[N+1];
		light = new int[N][2];
		signal[0] = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			signal[i+1] = Integer.parseInt(st.nextToken());
			rg = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			light[i] = rg;
		}
		
		for(int i=0; i<N; i++) {
			sec+=signal[i+1]-signal[i]; // 다음 신호등까지 가는데 걸린 시간
			int now = sec%(light[i][0]+light[i][1]); // 빨간불에 걸리는지 초록불에 걸리는지
			if(now<light[i][0]) { 
				sec+=(light[i][0]-now); // 빨간불이면 더함
			}
		}
		sec+=(L-signal[N]);
		System.out.println(sec);
	}
}
