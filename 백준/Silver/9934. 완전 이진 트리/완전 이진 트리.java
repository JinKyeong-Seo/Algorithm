import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder[] sb;
	static int[] tree;
	static int K;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		tree = new int[(int) Math.pow(2, K)];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder[K];
		for(int i=0; i<K; i++) sb[i] = new StringBuilder();

		inorder(1, tree.length-1, 0);
		
		StringBuilder res = new StringBuilder();
		for(int i=0; i<K; i++) {
			res.append(sb[i]);
			res.append("\n");
		}
		
		System.out.println(res);
	}
	
	public static void inorder(int s, int e, int h) {
		if(h==K) return;
		
		int mid = (s+e)/2;
		sb[h].append(tree[mid]).append(" ");
		inorder(s, mid-1, h+1);
		inorder(mid+1, e, h+1);
	}
}
