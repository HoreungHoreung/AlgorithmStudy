import java.io.*;
import java.util.*;
public class Main {
    private static int N, M;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, dy = {-1, -1, 0, 1 ,1, 1, 0, -1};
    private static int[][] grid;
    private static List<Cloud> clouds = new ArrayList<>();

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static class Cloud{
        int x, y;
        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void move(int d, int s) {
        for(Cloud c : clouds) {
//            c.x = (c.x + (dx[d] + N) * s) % N;
//            c.y = (c.y + (dy[d] + N) * s) % N;
            c.x = ((c.x + dx[d] * s) % N + N) % N;
            c.y = ((c.y + dy[d] * s) % N + N) % N;

            grid[c.x][c.y] += 1;
        }

        for(Cloud c : clouds) {
            //물복사버그 시전
            for(int i = 1; i <= 7; i += 2) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if(inRange(nx, ny) && grid[nx][ny] > 0) {
                    grid[c.x][c.y] += 1; //현재 바구니 더해져야함
                }
            }
        }
        makeCloud();
    }

    private static void makeCloud() {
        List<Cloud> temp = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] >= 2 && notPrev(i, j)) {
                    temp.add(new Cloud(i, j));
                    grid[i][j] -= 2;
                }
            }
        }

        clouds = temp;
    }

    private static boolean notPrev(int x, int y) {
        for(Cloud c : clouds) {
            if(c.x == x && c.y == y) return false;
        }
        return true;
    }

    /*
    행열 연결 -> mod 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기 구름 위치
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            move(d, s);
        }

        //물양 총합
        int sum = 0;
        for(int[] g : grid) {
            for(int water : g) {
                sum += water;
            }
        }

        br.close();
        System.out.println(sum);
    }
}
