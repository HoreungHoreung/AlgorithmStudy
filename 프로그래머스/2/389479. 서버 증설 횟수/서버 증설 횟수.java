import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Deque<Integer> active = new ArrayDeque<>();
        
        for(int i = 0; i < 24; i++) {
            int need = players[i] / m;
            while(!active.isEmpty() && active.peekFirst() <= i) {
                active.pollFirst();
            }
            
            int server = active.size();
            if(need > server) {
                answer += (need - server);
                for(int j = 0; j < need - server; j++) {
                    active.addLast(i + k);
                }
            }  
        }
        return answer;
    }
}