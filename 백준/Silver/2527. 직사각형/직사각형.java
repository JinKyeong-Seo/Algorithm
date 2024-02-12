import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        
        for(int t=0; t<4; t++) {
            boolean r = false, c = false, rs = false, cs = false;
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<8; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	// r 포함관계
        	if((arr[0]<=arr[4] && arr[4]<=arr[2]) || (arr[4]<=arr[0] && arr[0]<=arr[6])) {
        		r = true;
        	}
        	
        	// c 포함관계
        	if((arr[1]<=arr[5] && arr[5]<=arr[3]) || (arr[5]<=arr[1] && arr[1]<=arr[7])) {
        		c = true;
        	}
        	
        	// 가로면이 닿아있는가
        	if(arr[2]==arr[4] || arr[0]==arr[6]) {
        		rs = true;
        	}
        	
        	// 세로면이 닿아있는가
        	if(arr[3]==arr[5] || arr[1]==arr[7]) {
        		cs = true;
        	}
        	
        	if(r&&c) {
        		if(rs&&cs) sb.append("c\n");
            	else if (rs||cs) sb.append("b\n");
            	else sb.append("a\n");
        	} else {
        		sb.append("d\n");
        	}
        }
        System.out.println(sb.toString());
    }    
}