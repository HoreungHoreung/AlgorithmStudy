class Solution {
    private static int[] ans = new int[3];
    private static int[] numbers;
    private static int answer = 0;
    
    private static void combination(int cnt, int start) {
        if(cnt == 3) {
            int sum = 0;
            for(int num : ans) {
                sum += num;
            }
            if(sum == 0) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < numbers.length; i++) {
            ans[cnt] = numbers[i];
            combination(cnt + 1, i + 1);
        }
    }
    
    public int solution(int[] number) {
        ans = new int[3];
        numbers = number;
        
        combination(0, 0);
        
        return answer;
    }
}