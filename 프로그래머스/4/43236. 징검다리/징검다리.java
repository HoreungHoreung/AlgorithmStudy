import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int rockNum = rocks.length;
        int start = 1;
        int end = distance;
        Arrays.sort(rocks);
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            long prev = 0;
            for(int i = 1; i < rockNum; i++) {
                if(rocks[i] - rocks[i - 1] > mid) {
                    cnt++;
                }
            }
            
            if(cnt - n < )
        }
        
        return answer;
    }
}