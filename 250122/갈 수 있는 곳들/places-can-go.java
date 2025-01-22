import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n, k;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int cnt = 0;

    public static Queue<Pair> queue = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs(Pair currPair) {
        if(!visited[currPair.x][currPair.y]) cnt++;
        queue.add(currPair);
        visited[currPair.x][currPair.y] = true;

        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int currX = curr.x;
            int currY = curr.y;

            for(int i =  0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(canGo(newX, newY)) {
                    cnt++;
                    queue.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static void initializeVisits() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y] || grid[x][y] == 1) return false;
        return true;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Pair pair = new Pair(a-1, b-1);
            bfs(pair);
            //initializeVisits();
        }

        bw.write(String.valueOf(cnt));
        br.close();
        bw.flush();
        bw.close();
    }
}
