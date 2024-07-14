import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<String>[] arr = new ArrayList[11];
		for(int i=0; i<11; i++) arr[i] = new ArrayList<>();
		arr[0].add("1");
		arr[1].add("1+1");
		arr[1].add("2");
		arr[2].add("1+1+1");
		arr[2].add("1+2");
		arr[2].add("2+1");
		arr[2].add("3");
		
		for(int i=3; i<n; i++) {
			for(int j=1; j<=3; j++) {
				for(int x=0; x<arr[i-j].size(); x++) {
					arr[i].add(arr[i-j].get(x)+"+"+j);
				}
			}
		}
		Collections.sort(arr[n-1]);
		
		String res = "-1";
		if(k<=arr[n-1].size()) res = arr[n-1].get(k-1);
		
		System.out.println(res);
	}
}
