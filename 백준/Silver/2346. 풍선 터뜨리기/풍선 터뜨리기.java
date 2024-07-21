import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> balloon = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            int[] arr= {i+1,Integer.parseInt(st.nextToken())};
            balloon.add(arr);
        }
        while(balloon.size()>1){
            int[] arr= balloon.pollFirst();
            sb.append(arr[0]).append(" ");
            int n = arr[1];
            if(n>0) {
                for(int j=1; j<n;j++) {
                	balloon.offerLast(balloon.pollFirst());
                }
            }
            else if(n<0){
                for(int j=n;j!=0;j++) {
                	balloon.offerFirst(balloon.pollLast());
                }
            }
        }
        sb.append(balloon.poll()[0]);
        System.out.println(sb);
	}
}
