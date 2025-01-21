import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grid;
    public static int[][] visited;
    public static int maxCnt = 0;
    public static int cnt = 0;
    public static int n;

//    public static void initializeVisited() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                visited[i][j] = 0;
//            }
//        }
//    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y, int num) {
        if (!inRange(x, y)) return false;
        if (grid[x][y] != num || visited[x][y] == 1) return false;
        return true;
    }

    public static void DFS(int x, int y, int num) {
        visited[x][y] = 1;
        cnt++;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY, num)) {
                DFS(newX, newY, num); // 이동 좌표 수정
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numBoom = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currV = grid[i][j];
                if (canGo(i, j, currV)) {
                    DFS(i, j, currV);
                    maxCnt = Math.max(maxCnt, cnt);
                    
                    if (cnt >= 4) {
                        numBoom++; // 폭발 개수 누적
                        //maxCnt = Math.max(maxCnt, cnt); // 최대 크기 갱신
                    }

                    cnt = 0; // 다음 그룹을 위해 초기화
                }
            }
        }

        sb.append(numBoom).append(" ").append(maxCnt).append("\n");
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}