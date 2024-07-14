import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] mode = new int[8001];
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mode[arr[i]+4000]++;
			sum+=arr[i];
		}
		Arrays.sort(arr);
		
		sb.append((int) Math.round((double)sum/N)).append("\n");
		sb.append(arr[N/2]).append("\n");
		sb.append(findMode(mode)).append("\n");
		sb.append(arr[N-1]-arr[0]);
		
		System.out.println(sb);
		
	}
	
	public static int findMode(int[] mode) {
		int max = Integer.MIN_VALUE;
		int res = 0;
		boolean flag = false;
		for (int i = 0; i <8001; i++) {
		    if (mode[i] > max) {
		    	res = i - 4000;
		        max = mode[i];
		        flag = true;
		    } else if (mode[i] == max && flag == true) {
		        res = i - 4000;
		        flag = false;
		    }
		}
		return res;
	}
}
