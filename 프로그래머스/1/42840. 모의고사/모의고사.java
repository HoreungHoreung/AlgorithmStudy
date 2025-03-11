import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        Queue<Integer> soo_1 = new LinkedList<>();
        Queue<Integer> soo_2 = new LinkedList<>();
        Queue<Integer> soo_3 = new LinkedList<>();
        int[] soo_1_arr = new int[] {1, 2, 3, 4, 5};
        int[] soo_2_arr = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] soo_3_arr = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int num : soo_1_arr) {
            soo_1.add(num);
        }
        
        for(int num : soo_2_arr) {
            soo_2.add(num);
        }
        
        for(int num : soo_3_arr) {
            soo_3.add(num);
        }
        
        int soo_1_cnt = 0;
        int soo_2_cnt = 0;
        int soo_3_cnt = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int score = answers[i];
            int soo_1_score = soo_1.poll();
            int soo_2_score = soo_2.poll();
            int soo_3_score = soo_3.poll();
            
            if(score == soo_1_score) soo_1_cnt++;
            if(score == soo_2_score) soo_2_cnt++;
            if(score == soo_3_score) soo_3_cnt++;
            
            soo_1.add(soo_1_score);
            soo_2.add(soo_2_score);
            soo_3.add(soo_3_score);
        }
        
        System.out.println(soo_1_cnt);
        System.out.println(soo_2_cnt);
        System.out.println(soo_3_cnt);
        
        int maxScore = Math.max(soo_1_cnt, Math.max(soo_2_cnt, soo_3_cnt));
        List<Integer> winners = new ArrayList<>();
        
        if(soo_1_cnt == maxScore) winners.add(1);
        if(soo_2_cnt == maxScore) winners.add(2);
        if(soo_3_cnt == maxScore) winners.add(3);
        
        return winners.stream().mapToInt(i -> i).toArray();
    }
}