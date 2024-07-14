import java.io.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[1000001];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i=4; i<1000001; i++) {
			arr[i] = (arr[i-1]+arr[i-2]+arr[i-3])%1000000009;
		}
		
		for(int t=0; t<T; t++) {
			int now = Integer.parseInt(br.readLine());
			sb.append(arr[now]).append("\n");
		}
		
		System.out.println(sb);
	}
}
