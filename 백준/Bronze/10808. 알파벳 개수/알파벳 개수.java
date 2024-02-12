import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		int[] arr = new int[26];
		
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			++arr[c-'a'];
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
