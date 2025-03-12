import java.util.*;
class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] numStrArr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numStrArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(numStrArr, (a, b) -> (b + a).compareTo(a + b));
        
        for(String str : numStrArr) {
            sb.append(str);
        }
        
        if(sb.toString().charAt(0) == '0') {return "0";};
        
        return sb.toString();
    }
}