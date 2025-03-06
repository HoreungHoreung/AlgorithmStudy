import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int tempI = commands[i][0];
            int tempJ = commands[i][1];
            int tempK = commands[i][2];
            
            int[] temp = Arrays.copyOfRange(array, tempI - 1 , tempJ);
            Arrays.sort(temp);
            answer[i] = temp[tempK - 1];
        }
        return answer;
    }
}