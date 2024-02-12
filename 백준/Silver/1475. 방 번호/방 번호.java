import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] arr = new int[10];
		
		for(int i=0; i<N.length(); i++) {
			char c = N.charAt(i);
			++arr[c-'0'];
		}
		
		arr[6] = (arr[6]+arr[9])/2 + (arr[6]+arr[9])%2;
		arr[9] = 0;

		int max = 0;
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(max);
	}
}
