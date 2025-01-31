import java.util.*;

public class Main {

    private static int N, M, currDir;
    private static int[][] grid;
    private static boolean[][] visited;

    private static int[] dx = new int[] {-1, 0, 1, 0};
    private static int[] dy = new int[] {0, 1, 0, -1};

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static int clean(int x, int y) {
        int cleaned = 0;

        while(true) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                cleaned++;
            }

            boolean moved = false;
            for(int i = 0; i < 4; i++) {
                currDir = (currDir + 3) % 4;
                int newX = x + dx[currDir];
                int newY = y + dy[currDir];

                if(inRange(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                    x = newX;
                    y = newY;
                    moved = true;
                    break;
                }
            }

            if(!moved) {
                int backX = x - dx[currDir];
                int backY = y - dy[currDir];

                if(inRange(backX, backY) && grid[backX][backY] == 0) {
                    x = backX;
                    y = backY;
                } else {
                    return cleaned;
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

        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                grid[row][col] = sc.nextInt();
            }
        }

        System.out.println(clean(startX, startY));
        sc.close();
    }
}