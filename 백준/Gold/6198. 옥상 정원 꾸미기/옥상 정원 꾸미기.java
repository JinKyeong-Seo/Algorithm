import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long res = 0L;
		Stack<Integer> building = new Stack<>();
		building.push(Integer.parseInt(br.readLine()));
		
		for(int i=0; i<N-1; i++) {
			int curr = Integer.parseInt(br.readLine());
			if(building.peek()>curr) {
				res+=building.size();
				building.push(curr);
			}
			else {
				while(!building.isEmpty() && building.peek()<=curr) {
					building.pop();
				}
				res+=building.size();
				building.push(curr);
			}
		}
		System.out.println(res);
	}
}
