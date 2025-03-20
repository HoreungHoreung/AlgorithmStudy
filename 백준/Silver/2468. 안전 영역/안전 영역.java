import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * 1. 시간복잡도
 * O(n)
 * 2. 푸는 방법
 *
 *
 */
public class Main {

    private static int N;
    private static int[][] grid;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};


    private static void resetVisited() {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited.length; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void bfs(int[] curr, int level) {
        Deque<int[] > deque = new ArrayDeque<>();
        deque.addLast(curr);
        visited[curr[0]][curr[1]] = true;


        while(!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if((0 <= newX && newX < N && 0 <= newY && newY < N) && (!visited[newX][newY]) && (grid[newX][newY]) >= level) {
                    deque.addLast(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited =  new boolean[N][N];

        int maxLevel = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxLevel = Math.max(maxLevel, grid[i][j]);
            }
        }

        int answer = 0;
        for(int level = 1 ; level <= maxLevel; level++) {
            resetVisited();
            int currMax = 0;
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    if(!visited[row][col] && grid[row][col] >= level) {
                        bfs(new int[] {row, col}, level);
                        currMax++;
                    }
                }
            }

            answer = Math.max(answer, currMax);
        }

        System.out.println(answer);
    }
}
