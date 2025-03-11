class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        
        while(index < s.length()) {
            char x = s.charAt(index);
            int countX = 0, countOther = 0;
            
            while(index < s.length()) {
                if (s.charAt(index) == x) {
                    countX++;
                } else countOther++;
                
                index++;
                
                if(countX == countOther) break;
            }
            answer++;
        }
        
        return answer;
    }
}