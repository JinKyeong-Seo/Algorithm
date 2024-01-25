import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int res = 0;
		for (int i=1;i<=N;i++) {
			if (i==1) {
				res+=N;
			} else {
				int idx = i;
				while (i*idx<=N) {
					res++;
					idx++;
				}
			}
		}
		
		System.out.println(res);
		
	}
}