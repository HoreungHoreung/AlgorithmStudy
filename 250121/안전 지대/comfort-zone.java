import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[][] grid;
    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x, int y, int level) {
        if (!inRange(x, y)) return false;
        if (visited[x][y] || grid[x][y] <= level) return false;
        return true;
    }

    public static void DFS(int x, int y, int level) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny, level)) {
                DFS(nx, ny, level);
            }
        }
    }

    public static int getSafeZones(int level) {
        visited = new boolean[N][M];
        int safeZones = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (canGo(i, j, level)) {
                    DFS(i, j, level);
                    safeZones++;
                }
            }
        }

        return safeZones;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        int maxHeight = 0;

        // 입력 처리 및 최대 높이 계산
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        int maxSafeZones = 0;
        int optimalLevel = 0;

        // 각 레벨에 대해 안전 영역 계산
        for (int level = 1; level <= maxHeight; level++) {
            int safeZones = getSafeZones(level);

            if (safeZones > maxSafeZones) {
                maxSafeZones = safeZones;
                optimalLevel = level;
            } else if (safeZones == maxSafeZones) {
                optimalLevel = Math.min(optimalLevel, level);
            }
        }

        bw.write(optimalLevel + " " + maxSafeZones + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}