import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int MX, head, tail, num;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		MX = 50000;
		arr = new int[MX*2+1];
		head = MX; tail = MX; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				arr[--head] = num;
			} else if (str.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				arr[tail++] = num;
			} else if (str.equals("pop_front")) {
				if(head!=tail) {
					sb.append(arr[head++]).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (str.equals("pop_back")) {
				if(head!=tail) {
					sb.append(arr[--tail]).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (str.equals("size")) {
				sb.append(tail-head).append("\n");
			} else if (str.equals("empty")) {
				if(head==tail) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			} else if (str.equals("front")) {
				if(head!=tail) {
					sb.append(arr[head]).append("\n");					
				} else {
					sb.append(-1).append("\n");
				}
			} else {
				if(head!=tail) {
					sb.append(arr[tail-1]).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}	
		}
		
		System.out.println(sb);
	}
}
