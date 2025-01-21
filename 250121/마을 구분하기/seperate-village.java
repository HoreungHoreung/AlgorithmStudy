import javax.lang.model.SourceVersion;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] grid;
    public static int[][] visited;
    public static int n;
    public static int cnt = 0;
    public static ArrayList<Integer> cntPeople = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 0 || visited[x][y] == 1) return false;
        return true;
    }

    public static void DFS(int x, int y) {

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        visited[x][y] = 1;
        cnt += 1;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(canGo(newX, newY)) DFS(newX, newY);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];


        //입력값 -> grid
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //grid에서 방문하지 않은 모든값들 DFS
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 0;
                    DFS(i, j);
                    cntPeople.add(cnt);
                }
            }
        }

        cntPeople.sort(Comparator.naturalOrder());
        bw.write(cntPeople.size() + "\n");
        for (Integer i : cntPeople) {
            bw.write(i + "\n");
        }

//        DFS(4, 0);
//        System.out.println(cnt);
        br.close();
        bw.flush();
        bw.close();
    }
}
