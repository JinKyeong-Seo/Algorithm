import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr, sorted;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		sorted = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, N-1);
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static public void mergeSort(int left, int right) {
		if(left>=right) return;
		
		int mid = (left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		merge(left, mid, right);
	}
	
	static public void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L<=mid && R<=right) {
			if(arr[L][1]==arr[R][1]) {
				if(arr[L][0]<arr[R][0]) sorted[idx++] = arr[L++];
				else sorted[idx++] = arr[R++];
			} else if(arr[L][1]<arr[R][1]) {
				sorted[idx++] = arr[L++];
			} else {
				sorted[idx++] = arr[R++];
			}
		}
		
		if(L<=mid) {
			for(int i=L; i<=mid; i++) {
				sorted[idx++] = arr[i];
			}
		}
		
		if(R<=right) {
			for(int i=R; i<=right; i++) {
				sorted[idx++] = arr[i];
			}
		}
		
		for(int i=left; i<=right; i++) {
			arr[i] = sorted[i];
		}
	}
}
