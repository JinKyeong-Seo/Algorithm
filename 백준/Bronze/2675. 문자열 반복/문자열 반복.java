import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			String text = "";
			for (int i=0; i<str.length(); i++) {
				for(int j=0; j<R; j++) {
					text+=str.charAt(i);
				}			
			}
			System.out.println(text);
		}
	}
}
