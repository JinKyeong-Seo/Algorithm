import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        rows.add(0);
        columns.add(0);
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1) rows.add(Integer.parseInt(st.nextToken()));
            else columns.add(Integer.parseInt(st.nextToken()));
        }
        rows.add(r);
        columns.add(c);
        Collections.sort(rows);
        Collections.sort(columns);
        
        int row = Integer.MIN_VALUE;
        int column = Integer.MIN_VALUE;
        for(int i=0; i<rows.size()-1; i++) {
        	int num = rows.get(i+1)-rows.get(i);
        	if (num>row) {
        		row = num;
        	}
        }
        for(int i=0; i<columns.size()-1; i++) {
        	int num = columns.get(i+1)-columns.get(i);
        	if (num>column) {
        		column = num;
        	}
        }
        System.out.println(row*column);
    }
}