import java.io.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static String[] str;
	static int N;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[] {"\"재귀함수가 뭔가요?\"\n",
				"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		program(0);
		System.out.println(sb);
	}
	
	static void program(int i) {
		if(i==N) {
			sb.append("_".repeat(i*4)).append("\"재귀함수가 뭔가요?\"\n");
			sb.append("_".repeat(i*4)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append("_".repeat(i*4)).append("라고 답변하였지.\n");
			return;
		}
		
		
		for(int s=0; s<4; s++) {
			sb.append("_".repeat(i*4));
			sb.append(str[s]);
		}
		program(i+1);
		sb.append("_".repeat(i*4)).append("라고 답변하였지.\n");	
	}
	
}
