import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> nums = new ArrayList<>();
        for(String op : operations) {
            Collections.sort(nums);
            String[] ops = op.split(" ");
            String command = ops[0];
            int num = Integer.parseInt(ops[1]);
            
            if(command.equals("I")) {
                nums.add(num);
            } else if(command.equals("D")) {
                if(nums.size() == 0) continue;
                if(num == 1) {
                    nums.get(nums.size() - 1);
                    nums.remove(nums.size() - 1);
                } else {
                    nums.get(0);
                    nums.remove(0);
                }
            }
        }
        
        Collections.sort(nums);
        
        if(nums.size() == 0) {
            answer[0] = 0; answer[1] = 0;
        } else {
            answer[0] = nums.get(nums.size() - 1);
            answer[1] = nums.get(0);
        }
        
        return answer;
    }
}