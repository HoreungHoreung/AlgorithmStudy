import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
//         int answer = 0;
//         List<Integer> arr = new LinkedList<>();
//         for(int i = 0; i < score.length; i++) {
//             arr.add(score[i]);
//         }
        
//         Collections.sort(arr, (a, b) -> {
//            return b.compareTo(a); 
//         });
        
//         for(int i = 0; i < arr.size() % m; i++)
        
        
        
//         return answer;
        
        Arrays.sort(score);
        int maxProfit = 0;
        int n = score.length;
        
        for(int i = n - m; i >= 0; i -= m) {
            maxProfit += score[i] * m;
        }
        return maxProfit;
    }
}