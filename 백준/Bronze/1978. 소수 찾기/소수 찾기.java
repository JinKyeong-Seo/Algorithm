import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		tc : for(int i=0; i<N; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(target==1) continue tc;
			for(int j=2; j*j<=target; j++) {
				if(target%j==0) {
					continue tc;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
