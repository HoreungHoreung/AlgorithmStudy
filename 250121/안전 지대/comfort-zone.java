

import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] grid;
    public static int[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x, int y, int level) {
        if (!inRange(x, y)) return false;
        if (visited[x][y] == 1 || grid[x][y] <= level) return false;
        return true;
    }

    public static void DFS(int x, int y, int level) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY, level)) DFS(newX, newY, level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int safeLevel = 0;
        int maxSafe = 0;

        for (int level = 1; level <= 100; level++) {
            visited = new int[N][M];
            int safeZones = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (canGo(i, j, level)) {
                        visited[i][j] = 1;
                        safeZones++;
                        DFS(i, j, level);
                    }
                }
            }

            if (safeZones > maxSafe) {
                maxSafe = safeZones;
                safeLevel = level;
            }
        }

        // 출력 형식 수정: System.out.println 사용
        System.out.println(safeLevel + " " + maxSafe);
    }
}