import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] house;
    static int N, C;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int n=0; n<N; n++) {
            house[n] = Integer.parseInt(br.readLine());
        } // 입력 끝
        Arrays.sort(house);


        System.out.println(binarySearch()-1);
    }

    public static int binarySearch() {
        int start = 1;
        int end = house[N-1]-house[0]+1;
        int mid;
        while(start < end) {
            mid = (start+end)/2;
            if(countWifi(mid) < C) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    public static int countWifi(int distance) {
        int cnt = 1;
        int prev = house[0];

        for(int n=1; n<N; n++) {
            if(house[n]-prev >= distance) {
                cnt++;
                prev = house[n];
            }
        }

        return cnt;
    }

}
