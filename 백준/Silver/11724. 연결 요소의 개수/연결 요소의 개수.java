import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] grid;
    private static boolean[] visited;

    private static void bfs(int curr) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(curr);
        visited[curr] = true;

        while(!deque.isEmpty()) {
            int next = deque.pollFirst();
            for(int i = 0; i < N; i++) {
                if(!visited[i] && grid[next][i] == 1){
                    deque.addLast(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()) - 1;

            grid[n][m] = 1;
            grid[m][n] = 1;
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }
}