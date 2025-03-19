import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        findK(K);
        System.out.println(sb.reverse());
    }

    public static void findK(int K) {
        int cnt = 2;
        int res = 2;
        while(res < K) {
            res += (int) Math.pow(2, cnt++);
        }
        cnt--;
        int target = K - (res - (int) Math.pow(2, cnt))-1;

        for(int n=0; n<cnt; n++) {
            if(target % 2 == 0) sb.append(4);
            else sb.append(7);
            target /= 2;
        }
    }
}