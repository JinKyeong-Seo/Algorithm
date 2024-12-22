import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Character.getNumericValue(str.charAt(i-1));
            arr[i] += arr[i-1];
        }

        int res = 0;
        out: for(int i = N/2*2; i >= 2; i -= 2){
            for(int j = 0; j+i <= N; j++){
                int mid = j+i/2;
                int end = j+i;

                int one = arr[mid] - arr[j];
                int two = arr[end] - arr[mid];
                if(one == two) {
                    res = i;
                    break out;
                }
            }
        }

        System.out.println(res);
    }
}
