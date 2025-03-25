import java.util.*;
class Solution {
    private static int result = 0;
    private static int[] arr;
    private static int[] nums;
    private static Set<Integer> set = new HashSet<>();
    private static boolean[] visited;
    private static boolean isPrime(int num) {
        if(num < 2) return false;
        else if(num == 2) return true;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    private static void permutation(int total, int cnt) {
        if(cnt == total) {
            String str = "";
            for(int i = 0; i < arr.length; i++) {
                str += arr[i];
            }
            if(isPrime(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
            return;
        }
        for(int i =  0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = nums[i];
                permutation(total, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        nums = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        for(int i = 1; i <= numbers.length(); i++) {
            arr = new int[i];
            visited = new boolean[nums.length];
            permutation(i, 0);
        }
        
        
        return set.size();
        
    }
}