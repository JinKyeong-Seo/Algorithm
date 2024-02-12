import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] boy = new int[6];
		int[] girl = new int[6];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			if(s==0) {
				girl[Integer.parseInt(st.nextToken())-1]++;
			} else {
				boy[Integer.parseInt(st.nextToken())-1]++;
			}
		}
		
		int res = 0;
		for(int i=0; i<6; i++) {
			res+=(girl[i]/k);
			res+=(boy[i]/k);
			if (girl[i]%k > 0) res++;
			if (boy[i]%k > 0) res++;
		}
		
		System.out.println(res);
	}
}
