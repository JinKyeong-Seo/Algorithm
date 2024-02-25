import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br;
	static int N, M;
	static long[] arrN, arrM;
	static long max;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arrN = new long[N];
			arrM = new long[M];
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				arrN[n] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arrM[m] = Long.parseLong(st.nextToken());
			}
			
			max = Long.MIN_VALUE;
			if(N<=M) {
				findMax(N, M, arrN, arrM);
			}
			else {
				findMax(M, N, arrM, arrN);
			}	
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	static void findMax(int a, int b, long[] arr1, long[] arr2) {
		for(int i=0; i<=b-a; i++) {
			long sum = 0;
			for(int j=0; j<a; j++) {
				sum+=arr1[j]*arr2[i+j];
			}
			max = Math.max(max, sum);
		}
	}
}