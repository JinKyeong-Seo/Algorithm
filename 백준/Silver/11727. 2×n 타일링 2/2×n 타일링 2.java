import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+2];
        arr[1] = 1;
        arr[2] = 3;
        for(int n=3; n<=N; n++) {
            arr[n] = (arr[n-1] + arr[n-2]*2)%10007;
        }
        System.out.println(arr[N]);
    }
}
