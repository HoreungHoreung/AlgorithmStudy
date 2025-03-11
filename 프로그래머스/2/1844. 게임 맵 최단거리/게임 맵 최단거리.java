import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        maps[0][0] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currCnt = curr[2];
            
            if(currX == n - 1 && currY == m - 1) return currCnt;
            
            for(int[] dir : directions) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];
                
                if(0 <= newX && newX < n && 0 <= newY && newY < m && maps[newX][newY] == 1){
                    maps[newX][newY] = 0;
                    queue.add(new int[] {newX, newY, currCnt + 1});
                }
            }
        }
        
        return -1;
    }
}