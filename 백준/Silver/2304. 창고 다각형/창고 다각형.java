import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
            if(value>max) {
                max = value;
            }
        }
        
        // key값 기준 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        
        // 빌딩 높이 중 최댓값 찾아 해당 인덱스 반환
        for(int i=keyList.size()-1; i>=0; i--) {
            if(map.get(keyList.get(i))==max) {
                maxIdx = i;
                break;
            }
        }
        
        int now = map.get(keyList.get(0)); // 현재 최장 높이
        for(int i=0; i<maxIdx; i++) {
            int num = map.get(keyList.get(i)); // 지금 높이
            int next = map.get(keyList.get(i+1)); // 다음 높이
            res+=((keyList.get(i+1)-keyList.get(i))*now);
            if(num<next && now<next) {
                now = next;
            }
        }
        now = map.get(keyList.get(keyList.size()-1));
        for(int i=keyList.size()-1; i>maxIdx; i--) {
            int num = map.get(keyList.get(i)); 
            int next = map.get(keyList.get(i-1)); 
            res+=((keyList.get(i)-keyList.get(i-1))*now);
            if(num<next && now<next) {
                now = next;
            }
        }
        res+=map.get(keyList.get(maxIdx));
        System.out.println(res);
    }
}