import java.io.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, sorted;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sorted = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, N-1);
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void mergeSort(int left, int right) {
		if(left>=right) return;
		
		int mid = (left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		merge(left, mid, right);
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L<=mid && R<=right) {
			if(arr[L]<=arr[R]) {
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
