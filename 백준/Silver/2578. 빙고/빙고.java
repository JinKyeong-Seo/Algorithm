import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] bingo = new int[5][5];
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int r=0; r<5; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<5; c++) {
        		bingo[r][c] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i=0; i<25; i++) {
        	if(i%5==0) st = new StringTokenizer(br.readLine());
        	int target = Integer.parseInt(st.nextToken());
        	out : for(int r=0; r<5; r++) {
            	for(int c=0; c<5; c++) {
            		if(bingo[r][c]==target) {
            			bingo[r][c] = 0;
            			break out;
            		}
            	}
            }
    		if(i>=11) {
    			if (check()>=3) {
    				System.out.println(i+1);
    				return;
    			}
    		}
        }  
    }
    
    public static int check() {
    	int res = 0;
    	int right = 0, left = 0;
    	for(int r=0; r<5; r++) {
    		int rSum = 0, cSum = 0;
    		for(int c=0; c<5; c++) {
    			rSum+=bingo[r][c];
    			cSum+=bingo[c][r];
    			if(r==c) right+=bingo[r][c];
    			if(r+c==4) left+=bingo[r][c];
    		}
    		if (rSum==0) res++;
    		if (cSum==0) res++;
    	}
    	if (right==0) res++;
    	if (left==0) res++;
    	return res;
    }
}