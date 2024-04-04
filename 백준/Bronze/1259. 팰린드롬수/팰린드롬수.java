import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String now = br.readLine();
		while (!now.equals("0")) {
			String res = "yes";
			if(now.length()==1) {
				sb.append(res).append("\n");
				now = br.readLine();
				continue;
			}
			int mid = now.length() / 2;
			int left = mid - 1;
			int right;
			if (now.length() % 2 == 0) {
				right = mid;
			} else {
				right = mid + 1;
			}
			while (left >= 0) {
				if (now.charAt(left) != now.charAt(right)) {
					res = "no";
					break;
				}
				left--;
				right++;
			}
			sb.append(res).append("\n");
			now = br.readLine();
		}
		System.out.println(sb);
	}
}
