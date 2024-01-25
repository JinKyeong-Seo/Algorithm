import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer> card = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			card.add(sc.nextInt());
		}
		
		Collections.sort(card);
		int res = 0;
		int sum = 0;
		for (int i=N-1; i>=0; i--) {
			for (int j=i-1; j>=0; j--) {
				for (int k=j-1;k>=0;k--) {
					sum = card.get(i)+card.get(j)+card.get(k);
					if (sum<=M && sum>res) {
						res = sum;
					}
				}
			}
		}
		System.out.println(res);
	}
}
