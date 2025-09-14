import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> hof = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++) {
            int cur = score[i];
            if(hof.size() == k) {
                if(hof.peek() < cur) {
                    hof.poll();
                    hof.offer(cur);
                }
            } else {
                hof.offer(cur);
            }
            answer[i] = hof.peek();
        }
        
        return answer;
    }
}