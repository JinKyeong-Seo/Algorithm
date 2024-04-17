import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		boolean zero = false;
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now==0) zero=true;
			else if(now>0) A.add(now);
			else B.add(now);
		}
		Collections.sort(A);
		Collections.sort(B);
		
		long res = 0;
		if(A.size()%2==1) {
			res = A.get(0);
			A.remove(0);
		} 
		for(int i=A.size()-1; i>=0; i = i-2) {
			if(A.get(i)==1 || A.get(i-1)==1) {
				res+=A.get(i);
				res+=A.get(i-1);
			} else {
				res+=A.get(i)*A.get(i-1);
			}
		}
		
		int bSize = B.size();
		for(int i=0; i<bSize; i=i+2) {
			if(i+1<bSize) {
				res+=B.get(i)*B.get(i+1);
			}
		}
		if(bSize%2==1) {
			if(!zero) res+=B.get(bSize-1);
		}
		System.out.println(res);
	}
}