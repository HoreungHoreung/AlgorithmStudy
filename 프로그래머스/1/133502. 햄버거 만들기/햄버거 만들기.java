import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> deque = new LinkedList<>();
        Integer[] target = new Integer[] {1, 2, 3, 1};
        
        for(int i : ingredient) {
            deque.addLast(i);
            if(deque.size() >= 4) {
                Integer[] temp = new Integer[4];
                
                Iterator<Integer> it = deque.descendingIterator();
                for(int j = 3; j >= 0 && it.hasNext(); j--) {
                    temp[j] = it.next();
                }
                
                // System.out.println(temp.toString());
                if(Arrays.equals(target, temp)) {
                    answer++;
                    for(int j = 0; j < 4; j++) {
                        deque.pollLast();
                    }
                }
            }
        }
        
        return answer;
    }
}