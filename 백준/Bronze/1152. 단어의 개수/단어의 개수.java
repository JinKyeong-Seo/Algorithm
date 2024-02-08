import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine());
		System.out.println(st.countTokens());
	}
}
