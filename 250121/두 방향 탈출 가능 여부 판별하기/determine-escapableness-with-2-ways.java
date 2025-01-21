import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid;
    public static int[][] visited;
    public static int[][] answer;
    public static int order = 1;
    public static int n, m;

    public static void DFS(int x, int y) {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        visited[x][y] = 1;
        answer[x][y] = order++;

        for(int i = 0; i < 2; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY)) DFS(newX, newY); 
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y) || grid[x][y] == 0) return false;
        return true;
    }



    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(answer[n-1][m-1] != 0) bw.write(String.valueOf(1));
        else bw.write(String.valueOf(0));

        br.close();
        bw.flush();
        bw.close();
    }
}