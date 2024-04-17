import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
    //     int ans = Integer.MAX_VALUE;
    //     for(int i=0; i<stones.length-k+1; i++){
    //         int max = 0;
    //         int maxIdx = 0;
    //         for(int j=i+k-1; j>=i; j--){
    //             if(stones[j]>max){
    //                 max = stones[j];
    //                 maxIdx = j;
    //             }
    //         }
    //         i=maxIdx;
    //         ans = Math.min(max, ans);
    //     }
    // return ans;
        int left = 1; //최소인원
        int right = Arrays.stream(stones).max().getAsInt(); //최대인원
        
        //이진탐색
        while(left <= right) { 
            int mid = (left + right) /2 ;  //중간값으로 탐색
            int cnt = 0; //연속된디딤돌
            
            for(int stone : stones) { //디딤돌배열순회
                if(stone < mid)//mid값보다 작다면 cnt++;
                    cnt++;
                else
                    cnt = 0; //아니라면 초기화
                
                if(cnt >= k) //연속된 디딤돌 개수가k랑같아지면 break
                    break;
            }
            if(cnt >= k) //연속된디딤돌개수가 k와같으면 최대인원 줄여야함
                right = mid-1; 
            else //반대라면 최소인원 늘려야함
                left = mid +1;
        }
        return left - 1;
    }
}