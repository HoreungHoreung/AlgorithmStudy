

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        int maxHeight = 0;

        // 입력받으면서 최대 높이 계산
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        int safeLevel = 0;
        int maxSafe = 0;

        for (int level = 1; level <= maxHeight; level++) {
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
            } else if (safeZones == maxSafe) {
                safeLevel = Math.min(safeLevel, level); // 최소 레벨 유지
            }
        }

        sb.append(safeLevel).append(" ").append(maxSafe).append("\n");
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}