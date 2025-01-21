import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4; // 방향 개수
    public static final int MAX_HEIGHT = 100;
    public static final int MAX_M = 50;
    public static final int MAX_N = 50;

    public static int N, M; // 격자 크기
    public static int[][] grid = new int[MAX_N][MAX_M]; // 높이 정보
    public static boolean[][] visited = new boolean[MAX_N][MAX_M]; // 방문 여부
    public static int safeZones; // 안전 영역 개수

    // visited 배열 초기화
    public static void initializeVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
    }

    // 주어진 좌표가 격자 범위 내에 있는지 확인
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    // 특정 위치로 이동 가능 여부 확인
    public static boolean canGo(int x, int y, int level) {
        if (!inRange(x, y)) 
            return false;

        if (visited[x][y] || grid[x][y] <= level)
            return false;

        return true;
    }

    // DFS 탐색
    public static void DFS(int x, int y, int level) {
        int[] dx = {0, 0, -1, 1}; // 상하좌우 방향
        int[] dy = {-1, 1, 0, 0};

        visited[x][y] = true;

        for (int dir = 0; dir < DIR_NUM; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (canGo(nx, ny, level)) {
                DFS(nx, ny, level);
            }
        }
    }

    // 특정 레벨에서 안전 영역 개수 계산
    public static void calculateSafeZones(int level) {
        safeZones = 0;
        initializeVisited();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (canGo(i, j, level)) {
                    safeZones++;
                    DFS(i, j, level);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSafeZones = -1;
        int optimalLevel = 0;

        N = sc.nextInt();
        M = sc.nextInt();

        // 격자 높이 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 각 가능한 비의 높이에 대해 안전 영역 계산
        for (int level = 1; level <= MAX_HEIGHT; level++) {
            calculateSafeZones(level);

            if (safeZones > maxSafeZones) {
                maxSafeZones = safeZones;
                optimalLevel = level;
            }
        }

        // 결과 출력
        System.out.println(optimalLevel + " " + maxSafeZones);
    }
}