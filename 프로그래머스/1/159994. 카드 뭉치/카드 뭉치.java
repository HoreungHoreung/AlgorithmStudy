import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Deque<String> card1 = new LinkedList<>(Arrays.asList(cards1));
        Deque<String> card2 = new LinkedList<>(Arrays.asList(cards2));
        // Deque<String> out = new LinkedList<>(Arrays.asList(goal));
        
        for(String g : goal) {
            if(g.equals(card1.peekFirst())) {
                card1.pollFirst();
            }
            else if(g.equals(card2.peekFirst())) {
                card2.pollFirst();
            }
            else{
                answer = "No";
                break;
            }
        }
        
        
        
        
        return answer;
    }
}