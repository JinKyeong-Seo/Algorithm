import java.io.*;
import java.util.*;

class Member {
	int age;
	String name;
	
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
}

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Member[] arr, sorted;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Member[N];
		sorted = new Member[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		mergeSort(0, N-1);
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i].age).append(" ").append(arr[i].name).append("\n");
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
			if(arr[L].age<=arr[R].age) sorted[idx++] = arr[L++];
			else sorted[idx++] = arr[R++];
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
