import java.util.*;
import java.io.*;

public class Main {

    private static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    private static int N, M;
    private static int minCnt = Integer.MAX_VALUE;
    private static int[][] grid;
    private static List<CCTV> cctvs = new ArrayList<>();

    private static int[][] directions = { //상, 우, 하, 좌
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    private static int[][][] cctvTypes = { //cctv 종류별 방향
            {},
            {{0}, {1}, {2}, {3}}, //1번
            {{0, 2}, {1, 3}}, // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, //3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, //4번
            {{0, 1, 2, 3}} //5번
    };

    private static void dfs(int cnt, int[][] currGrid) {
        if(cnt == cctvs.size()) {
            minCnt = Math.min(minCnt, countBlind(currGrid));
            return;
        }

        CCTV cctv = cctvs.get(cnt);
        int type = cctv.type;
        for(int[] dirs : cctvTypes[type]) {
            int[][] tempGrid = copyGrid(currGrid);
            for(int dir : dirs) {
                watch(tempGrid, cctv.x, cctv.y, dir);
            }
            dfs(cnt + 1, tempGrid);
        }
    }
    
    //한 방향으로 벽을 만나기 전까지 확인
    private static void watch(int[][] tempGrid, int x, int y, int dir) { 
        int newX = x;
        int newY = y;

        while(true) {
            newX += directions[dir][0];
            newY += directions[dir][1];

            if(!inRange(newX, newY)) break;
            if(tempGrid[newX][newY] == 6) break;

            if(tempGrid[newX][newY] == 0) {
                tempGrid[newX][newY] = 7;
            }
        }
    }

    private static boolean inRange(int x, int y) { //범위안에 있는지 확인
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static int[][] copyGrid(int[][] currGrid) { //깊은복사로 똑같은 배열 만들어서 체크
        int[][] copiedGrid = new int[N][M];

        for(int i = 0;i < N; i++) {
            for(int j = 0; j < M; j++) {
                copiedGrid[i][j] = currGrid[i][j];
            }
        }

        return copiedGrid;
    }

    private static int countBlind(int[][] currGrid) { //감시안된 부분 체크
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(currGrid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= grid[i][j] && grid[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, grid[i][j]));
                }
            }
        }

        dfs(0, grid);
        br.close();
        bw.write(String.valueOf(minCnt));
        bw.flush();
        bw.close();
    }
}
