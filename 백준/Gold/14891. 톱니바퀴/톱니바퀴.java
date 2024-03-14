
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int total, direction, magnetIdx;
	static int[][] magnet;
	static int[] idx, tmp;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		magnet = new int[4][8];
		for(int r=0; r<4; r++) {
			String str = br.readLine();
			for(int c=0; c<8; c++) {
				magnet[r][c] = str.charAt(c)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		idx = new int[4];
		for(int i=0; i<K; i++) {
			st  = new StringTokenizer(br.readLine());
			magnetIdx = Integer.parseInt(st.nextToken())-1;
			direction = Integer.parseInt(st.nextToken());
			// 내 왼쪽은 나의 -2과 왼쪽의 +2확인, 오른쪽은 나의 +2와 오른쪽의 -2확인
			tmp = Arrays.copyOf(idx,4);
			left(magnetIdx, direction);
			right(magnetIdx, direction);
			idx = Arrays.copyOf(tmp, 4);
			idx[magnetIdx] = ((idx[magnetIdx]-direction)+8)%8;				
		}
		
		total = 0;
		for(int s=0; s<4; s++) {
			if(magnet[s][idx[s]]==1) {
				total += Math.pow(2, s);
			}
		}	
		
		System.out.println(total);
	}
	
	static void left(int mIdx, int d) {
				
		while(mIdx>=1) {
			int me = ((idx[mIdx]-2)+8)%8;
			int left = (idx[mIdx-1]+2)%8;
			if(magnet[mIdx][me] == magnet[mIdx-1][left]) break;
			tmp[mIdx-1] = (idx[mIdx-1]+d+8)%8;
			d *= -1;
			mIdx--;
		}
		
	}
	
	static void right(int mIdx, int d) {	
		while(mIdx<=2) {
			int me = (idx[mIdx]+2)%8;
			int right = ((idx[mIdx+1]-2)+8)%8;
			if(magnet[mIdx][me] == magnet[mIdx+1][right]) break;
			tmp[mIdx+1] = (idx[mIdx+1]+d+8)%8;
			d *= -1;
			mIdx++;
		}
	}
}
