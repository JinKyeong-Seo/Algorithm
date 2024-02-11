import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static int N;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N][N];

		for (int n = 0; n < N; n++) {
			arr[n] = br.readLine().toCharArray();
		}
		
		int res = max(arr);
		if (res == N) {
			System.out.println(N);
			return;
		}
		
		out: for (int r=0; r<N; r++) {
			for (int c=0; c<N-1; c++) {
				if(arr[r][c]!=arr[r][c+1]) {
					char tmp = arr[r][c];
					arr[r][c] = arr[r][c+1];
					arr[r][c+1] = tmp;
					res = Math.max(res, max(arr));
					arr[r][c+1] = arr[r][c];
					arr[r][c] = tmp;
					
				}
				if(arr[c][r]!=arr[c+1][r]) {
					char tmp = arr[c][r];
					arr[c][r] = arr[c+1][r];
					arr[c+1][r] = tmp;
					res = Math.max(res, max(arr));
					arr[c+1][r] = arr[c][r];
					arr[c][r] = tmp;
				}
				if(res==N) {
					break out;
				}
			}
		}
		
		System.out.println(res);

	}

	public static int max(char[][] arr) {
		int max = Integer.MIN_VALUE;
		int rcnt = 1;
		int ccnt = 1;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N-1; c++) {
				if (arr[r][c] == arr[r][c+1])
					rcnt++;
				else {
					max = Math.max(max, rcnt);
					rcnt = 1;
				}

				if (arr[c][r] == arr[c+1][r]) {
					ccnt++;
				} else {
					max = Math.max(max, ccnt);
					ccnt = 1;
				}
				max = Math.max(max, Math.max(rcnt, ccnt));
			}
			rcnt = 1;
			ccnt = 1;
		}
		return max;
	}
}
