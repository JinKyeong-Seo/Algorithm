import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[] arr = new int[1000000];
		
		int res = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>=target) continue;
			if(target-num>1000000) continue;
			if(arr[target-num]==1) res++;
			arr[num] = 1;
		}
		
		System.out.println(res);
	}
}
