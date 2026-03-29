import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static boolean isCycle = false;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);

                if (c == 'H') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = c - '0';
                }
            }
        }

        int result = dfs(0, 0);

        if (isCycle) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    static int dfs(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M || board[y][x] == -1) {
            return 0;
        }

        if (visited[y][x]) {
            isCycle = true;
            return -1;
        }

        if (dp[y][x] > 0) {
            return dp[y][x];
        }

        visited[y][x] = true;

        int jump = board[y][x];
        int maxMoves = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + (dy[i] * jump);
            int nx = x + (dx[i] * jump);

            maxMoves = Math.max(maxMoves, dfs(ny, nx) + 1);

            if (isCycle) return -1;
        }

        visited[y][x] = false;

        return dp[y][x] = maxMoves;
    }



}