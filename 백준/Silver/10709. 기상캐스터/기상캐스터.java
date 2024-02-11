import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] region = new int[H][W];
        
        for(int h=0; h<H; h++) {
        	String text = br.readLine();
        	next : for(int w=0; w<W; w++) {
        		char c = text.charAt(w);
        		if(c=='c') region[h][w] = 0;
        		else {
        			int idx = 1;
        			int nw = w-idx;
        			while(nw>=0) {
        				if(region[h][nw]==0) {
        					region[h][w] = idx;
        					continue next;
        				}
        				idx++;
        				nw = w-idx;
        			}
        			region[h][w] = -1;
        		}
        	}
        }
        
        for(int h=0; h<H; h++) {
        	for(int w=0; w<W; w++) {
        		System.out.print(region[h][w]+" ");
        	}
        	System.out.println();
        }
         
    }    
}