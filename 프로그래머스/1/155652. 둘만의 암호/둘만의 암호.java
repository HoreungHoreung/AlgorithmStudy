import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for(char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            char newChar = ch;
            int count = 0;
            
            while(count < index) {
                newChar++;
                
                if(newChar > 'z') newChar = 'a';
                
                if(!skipSet.contains(newChar)) count++;
            }
            
            sb.append(newChar);
        }
        return sb.toString();
    }
}