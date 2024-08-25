import java.util.*;
import java.text.*;

class Solution {
    static StringTokenizer st;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    Calendar cal = Calendar.getInstance();
    public int[] solution(String today, String[] terms, String[] privacies) {
        Date todate = new Date();
        try{
            todate = formatter.parse(today);
        }catch(ParseException e){
            throw new RuntimeException(e);
        }

        
        Map<String, String> termsMap = new HashMap<>();
        for(String term : terms){
            st = new StringTokenizer(term);
            termsMap.put(st.nextToken(), st.nextToken());
        }
        
        List<Integer> answer = new ArrayList<>();
        int idx = 1;
        for(String privacy : privacies){
            st = new StringTokenizer(privacy);
            String date = st.nextToken();
            String type = st.nextToken();
            try{
                Date privacyDate = formatter.parse(date);
                cal.setTime(privacyDate);
                cal.add(Calendar.MONTH, Integer.parseInt(termsMap.get(type)));
                Date now = cal.getTime();
                if(now.compareTo(todate) <= 0) answer.add(idx);
            }catch(ParseException e){
                throw new RuntimeException(e);
            }
            idx++;
        }
        
        for(int i : answer) System.out.println(i);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}