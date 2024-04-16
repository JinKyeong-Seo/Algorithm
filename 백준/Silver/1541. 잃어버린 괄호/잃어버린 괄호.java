import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Integer> number = new ArrayList<>();
		List<Character> operator = new ArrayList<>();
		
		int size = str.length();
		String num = "";
		for (int i = 0; i < size; i++) {
			if (str.charAt(i) == '-' || str.charAt(i) == '+') {
				number.add(Integer.parseInt(num));
				num = "";
				operator.add(str.charAt(i));
			} else num += str.charAt(i);
		}
		number.add(Integer.parseInt(num));
		
		int res = number.get(0);
		size = operator.size();
		for(int i=0; i<size; i++) {
			if (operator.get(i)=='+') {
				res+=number.get(i+1);
			} else {
				while(i<size) {
					res-=number.get(++i);
				}
			}
		}
		System.out.println(res);
	}
}


