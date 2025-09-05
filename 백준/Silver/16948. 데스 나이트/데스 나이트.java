import java.io.*;
import java.util.*;

// 10:00 시작 ->
public class Main {
    private static int N, minCnt = Integer.MAX_VALUE;
    private static int[][] board;
    private static int[] dx = {-2, -2, 0, 0, 2, 2}, dy = {-1, 1, -2, 2, -1, 1};
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    private static class Point{
        int x, y, moved;
        public Point(int x, int y, int moved) {
            this.x = x;
            this.y = y;
            this.moved = moved;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Deque<Point> deque = new ArrayDeque<>();
        deque.offerLast(new Point(r1, c1, 0));
        visited[r1][c1] = true;

        while(!deque.isEmpty()) {
            Point curr = deque.pollFirst();
            if(curr.x == r2 && curr.y == c2) {
                minCnt = Math.min(curr.moved, minCnt);
            }

            for(int i = 0; i < 6; i++) {
                int nx = curr.x  + dx[i], ny = curr.y + dy[i], nm = curr.moved + 1;
                if(inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deque.offerLast(new Point(nx, ny, nm));
                }
            }
        }

        br.close();
        if(minCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(minCnt);
        }
    }
}
