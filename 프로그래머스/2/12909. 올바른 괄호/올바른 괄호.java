import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(') deque.offerLast(curr);
            else if(curr == ')') {
                if(deque.isEmpty()) return false;
                deque.pollLast();
            }
        }
        
        if(!deque.isEmpty()) answer = false; 

        return answer;
    }
}