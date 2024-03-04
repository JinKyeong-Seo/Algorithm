import java.io.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int N, res;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = 1;
		sb.append((int) Math.pow(2, N)-1).append("\n");
		top(N, 1, 3);	
		System.out.println(sb);
	}
	static void top(int n, int a, int b) {
		if (n==1) {
			sb.append(a).append(" ").append(b).append("\n");
			return;
		}
		
		top(n-1, a, 6-a-b);
		sb.append(a).append(" ").append(b).append("\n");
		top(n-1, 6-a-b, b);
	}
}

