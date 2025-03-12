import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        
        for(int i = 1; i < food.length; i++) {
            int num_f = food[i];
            num_f /= 2;
            
            for(int j = 0; j < num_f; j++) {
                deque1.addLast(i);
                deque2.addLast(i);
            }
        }
        int len_1 = deque1.size();
        int len_2 = deque2.size();
        for(int i = 0; i < len_1; i++) {
            sb.append(deque1.pollFirst());
        }
        sb.append(0);
        for(int i = 0; i < len_2; i++) {
            sb.append(deque2.pollLast());
        }
        
        return sb.toString();
    }
}