import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		int idx = Integer.parseInt(br.readLine());
		char[] str = s.toCharArray();
		System.out.println(str[idx-1]);
	}
}
