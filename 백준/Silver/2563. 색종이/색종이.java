import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int[][] paper = new int[100][100];
		
		int area = 0;
		for (int n=0; n<N; n++) {
			int rs = sc.nextInt();
			int cs = sc.nextInt();
			for(int r=rs; r<=rs+9; r++) {
				for (int c=cs; c<=cs+9;c++) {
					if (paper[r][c]==0) {
						paper[r][c] = 1;
						area++;
					}
				}
			}
		}
		


		System.out.println(area);
	}
}
