import java.util.*;

public class Main {
    private static int N, M, currDir;
    private static int[][] grid;
    private static boolean[][] visited;

    private static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static int clean(int x, int y) {
        int cleaned = 0;

        while (true) {
            if (!visited[x][y]) { // 현재 위치 청소
                visited[x][y] = true;
                cleaned++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                currDir = (currDir + 3) % 4; // 반시계 방향 회전
                int newX = x + dx[currDir];
                int newY = y + dy[currDir];

                if (inRange(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                    x = newX;
                    y = newY;
                    moved = true;
                    break;
                }
            }

            if (!moved) { // 이동할 곳이 없으면 후진 시도
                int backX = x - dx[currDir];
                int backY = y - dy[currDir];

                if (inRange(backX, backY) && grid[backX][backY] == 0) {
                    x = backX;
                    y = backY;
                } else {
                    return cleaned; // 후진도 불가능하면 종료
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        currDir = sc.nextInt();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                grid[row][col] = sc.nextInt();
            }
        }

        int result = clean(startX, startY);
        System.out.println(result);
        sc.close();
    }
}