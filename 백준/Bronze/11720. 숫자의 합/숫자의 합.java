import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		int res = 0;
		for(int i=0; i<N; i++)
			res+=(nums.charAt(i)-'0');
		System.out.println(res);
	}
}
