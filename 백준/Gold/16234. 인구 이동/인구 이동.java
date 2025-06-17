import java.io.*;
import java.util.*;

public class Main {

    private static class Country {
        int x, y;

        public Country(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, L, R;
    private static int[][] grid;
    private static boolean[][] visited;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean bfs(int x, int y) {
        Deque<Country> deque = new ArrayDeque<>();
        List<Country> union = new ArrayList<>();

        deque.offerLast(new Country(x, y));
        visited[x][y] = true;
        union.add(new Country(x, y));

        int sum = grid[x][y];

        while (!deque.isEmpty()) {
            Country curr = deque.pollFirst();
            int currP = grid[curr.x][curr.y];

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    int np = grid[nx][ny];
                    int diff = Math.abs(currP - np);

                    if (L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        Country next = new Country(nx, ny);
                        deque.offerLast(next);
                        union.add(next);
                        sum += np;
                    }
                }
            }
        }

        if (union.size() == 1) return false; // 연합이 1개면 이동 없음

        int newP = sum / union.size();
        for (Country c : union) {
            grid[c.x][c.y] = newP;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) moved = true;
                    }
                }
            }

            if (!moved) break;
            day++;
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
        br.close();
    }
}