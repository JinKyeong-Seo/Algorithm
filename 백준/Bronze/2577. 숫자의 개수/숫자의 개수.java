import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int num = A*B*C;
		String text = num+"";
		
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			arr[c-'0']++;
		}
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+"\n");
		}

		System.out.println(sb.toString());
	}
}
