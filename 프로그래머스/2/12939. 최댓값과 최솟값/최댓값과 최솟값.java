import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<String> strArr = new ArrayList<>(Arrays.asList(s.split(" ")));
        System.out.println(strArr);
        int max = strArr.stream().mapToInt(ss -> Integer.parseInt(ss)).max().getAsInt();
        int min = strArr.stream().mapToInt(ss -> Integer.parseInt(ss)).min().getAsInt();
        
        if(s.length() == 1 && max == min) return answer += max;
        
        answer = answer + min + " " + max;
        return answer;
    }
}