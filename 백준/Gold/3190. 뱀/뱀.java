

import java.util.*;
import java.io.*;

public class Main {
    private static int N, K, L;
    private static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    private static int[] dy = {1, 0, -1, 0};

    static class Pos {
        int time;
        char direction;

        public Pos(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    private static boolean canGo(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        Deque<Pos> turns = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            turns.offerLast(new Pos(time, direction));
        }

        int time = 0;
        int dir = 0;
        int x = 0, y = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{x, y});
        grid[x][y] = 2;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!canGo(nx, ny) || grid[nx][ny] == 2) break;

            if (grid[nx][ny] == 1) {
                grid[nx][ny] = 2;
                snake.addLast(new int[]{nx, ny});
            } else {
                grid[nx][ny] = 2;
                snake.addLast(new int[]{nx, ny});
                int[] tail = snake.pollFirst();
                grid[tail[0]][tail[1]] = 0;
            }

            x = nx;
            y = ny;

            if (!turns.isEmpty() && turns.peekFirst().time == time) {
                Pos p = turns.pollFirst();
                if (p.direction == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }

        br.close();
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }
}
