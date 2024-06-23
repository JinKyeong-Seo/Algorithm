import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int last = -1;
		for(int i=0; i<N; i++) {
			int milk = Integer.parseInt(st.nextToken());
			if(cnt == 0) {
				if(milk==0) {
					cnt++;
					last = 0;
				}
			} else {
				if((last==2 && milk==0) || (last==0 && milk==1) || (last==1 && milk==2)) {
					cnt++;
					last = milk;
				}
			}
		}
		System.out.println(cnt);
	}
}
