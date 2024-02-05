import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
        
        for (int t=1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
            st.nextToken();
            
            int[] student = new int[20];
            int num = 0;
            
            // 배열 생성
            for (int n=0; n<20; n++) { // 20명에 대해 수행
                student[n] = Integer.parseInt(st.nextToken());
                for(int m=0; m<=n; m++) {  // 0~n 자신까지 중
                    if(student[n]<student[m]) { // 나보다 큰 학생 있는지 확인
                        for(int i=n; i>m; i--) {
                            num++;
                            int tmp = student[i];
                            student[i] = student[i-1];
                            student[i-1] = tmp;
                        }
                    }
                }
            }
            
            System.out.println(t+" "+num);

        }

	}
}
