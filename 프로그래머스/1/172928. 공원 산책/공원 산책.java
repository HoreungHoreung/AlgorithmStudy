import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        int[] position = new int[2];
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(park[i].charAt(j) == 'S'){
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        
        Map<String, int[]> directions = new HashMap<>();
        directions.put("N", new int[]{-1, 0});
        directions.put("S", new int[]{1, 0});
        directions.put("E", new int[]{0, 1});
        directions.put("W", new int[]{0, -1});
        
        for(String route : routes) {
            String parts[] = route.split(" ");
            String dir = parts[0];
            int dist = Integer.parseInt(parts[1]);
            
            int[] move = directions.get(dir);
            int newRow = position[0], newCol = position[1];
            boolean canMove = true;
            
            for(int i = 0; i < dist; i++) {
                newRow += move[0];
                newCol += move[1];
                
                if(newRow < 0 || newRow >= height || newCol < 0 || newCol >= width || park[newRow].charAt(newCol) == 'X') {
                    canMove = false;
                    break;
                }
            
            }
            
            if(canMove) {
                position[0] = newRow;
                position[1] = newCol;
            }
        }
        return position;
    }
}