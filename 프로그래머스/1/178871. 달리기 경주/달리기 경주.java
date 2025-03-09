import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        int index = 0;
        for(String p : players) {
            map.put(p, index++);
        }
        
        for(String c : callings) {
            int calledIndex = map.get(c).intValue();
            int targetIndex = calledIndex - 1;
            
            String targetPlayer = players[targetIndex];
            players[calledIndex] = players[targetIndex];
            players[targetIndex] = c;
            
            map.put(c,targetIndex);
            map.put(targetPlayer, calledIndex);
        }
        
        return players;
    }
}