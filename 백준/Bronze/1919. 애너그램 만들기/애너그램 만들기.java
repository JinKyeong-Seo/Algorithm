import java.io.*;
import java.util.Arrays;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String one = br.readLine();
		String two = br.readLine();
		int[] arr = new int[26];
		int res = 0;
		
		for(int i=0; i<one.length(); i++) {
			char c = one.charAt(i);
			++arr[c-'a'];
		}
		
		for(int i=0; i<two.length(); i++) {
			char c = two.charAt(i);
			--arr[c-'a'];
		}
		
		for(int i=0; i<arr.length; i++) {
			res+=Math.abs(arr[i]);
		}
		System.out.println(res);
	}
}
