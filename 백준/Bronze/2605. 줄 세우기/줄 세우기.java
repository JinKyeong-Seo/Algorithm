import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> nums = new ArrayList<>(); // 뽑은 번호
		List<Integer> line = new ArrayList<>(); // 학생 줄 순서
		
		for (int i=0; i<N; i++) {
			nums.add(sc.nextInt());
			line.add(i+1);
		}
		
		for (int i=0; i<nums.size(); i++) {
			int idx = i-nums.get(i);
			line.set(i,0);
			for (int j=line.size()-1;j>=0;j--) {
				if (line.get(j)==0) {
					for (int k=0; k<nums.get(i);k++) {
						line.set(j, line.get(j-1));
						j--;
					}
				}
			}
			line.set(idx, i+1);
		}
		
		for (int l : line) {
			System.out.print(l+" ");
		}

	}
}