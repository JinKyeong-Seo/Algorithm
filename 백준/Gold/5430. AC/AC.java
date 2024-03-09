import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		tc : for(int t=1; t<=T; t++) {
			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> arr = new LinkedList<>();
			String tmp = br.readLine();
			String[] num = tmp.substring(1, tmp.length()-1).split(",");
			for(int i=0; i<N; i++) {
				arr.addLast(Integer.parseInt(num[i]));
			}
			
			int d = 1;
			for(int p=0; p<str.length(); p++) {
				char c = str.charAt(p);
				if (c=='R') {
					d*=-1;
				} else {
					if(arr.isEmpty()) {
						sb.append("error").append("\n");
						continue tc;
					}
					if(d==1) {
						arr.pollFirst();
					} else {
						arr.pollLast();
					}
				}
			}

			int total = arr.size()-1;
			sb.append("[");
			for(int i=0; i<total; i++) {
				if(d==1) {
					sb.append(arr.pollFirst()).append(",");
				} else {
					sb.append(arr.pollLast()).append(",");
				}
			}
			if(!arr.isEmpty()) sb.append(arr.pollFirst());
			sb.append("]").append("\n");
		}
		System.out.println(sb);
	}
}
