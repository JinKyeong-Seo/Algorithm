import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) list.add(i);
		
		int cnt = 0, idx = -1;
		sb.append("<");
		while(list.size()!=0) {
			++cnt; 
			idx = ++idx % list.size();
			if(cnt == K) {
				sb.append(list.get(idx)).append(", ");
				list.remove(idx);
				cnt = 0;
				idx--;
			}
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
	
}
