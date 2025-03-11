import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(hashMap.containsKey(currChar)) {
                int frontIndex = hashMap.get(currChar);
                answer[i] = i - frontIndex;
            } else {
                answer[i] = -1;
            }     
            hashMap.put(currChar, i);
        }
        
        return answer;
    }
}