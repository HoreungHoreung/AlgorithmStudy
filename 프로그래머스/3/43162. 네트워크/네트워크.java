import java.util.*;

class Solution {
    private static int N;
    private static boolean[] visited;
    private static int[][] coms;
    
    private static void bfs(int curr) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(curr);
        visited[curr] = true;
        
        while(!deque.isEmpty()) {
            int now = deque.pollLast();
            
            for(int i = 0; i < N; i++) {
                if(!visited[i] && coms[now][i] == 1) {
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        coms = computers;
        visited = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i);
            }
        }
        
        return answer;
    }
}