import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nxt : for(int i=0; i<M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now<arr[0] || arr[N-1]<now) sb.append(0).append("\n");
			else {
				int st = 0;
				int ed = N-1;
				while(st<=ed) {
					int mid = (st+ed)/2;
					if (arr[mid]==now) {
						sb.append(1).append("\n");
						continue nxt;
					}
					if(now<arr[mid]) ed = mid-1;
					else st = mid+1;
				}
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
