import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                deque.addLast(c);
            } else {
                if(deque.isEmpty()) {
                    answer = false;
                    break;
                }
                char prev = deque.pollLast();
                if (prev != '(') {
                    answer = false;
                    break;
                }
            }
        }
        
        if(deque.size() != 0) {
            return false;
        }
        
        return answer;
    }
}