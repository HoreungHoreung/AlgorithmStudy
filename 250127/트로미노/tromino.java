import java.util.*;
public class Main {
    public static int[][] grid;
    public static int n, m;
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    public static int threeHorizon(int row, int col) {
        int rowS = row;
        int rowE = row + 2;
        int cnt = 0;
        if(inRange(rowE, col)) {
            for(int i = rowS; i <= rowE; i++) {
                cnt += grid[i][col];
            }
        } else return 0;
        return cnt;
    }

    public static int threeVertical(int row, int col) {
        int colS = col;
        int colE = col + 2;
        int cnt = 0;
        if(inRange(row, colE)) {
            for(int j = 0; j <= colE; j++) {
                cnt += grid[row][j];
            }
        } else return 0;
        return cnt;
    }

    public static int curve(int row, int col) {
        int rowS = row;
        int rowE = row + 1;
        int colS = col;
        int colE = col + 1;
        int maxCnt = 0;

        if(inRange(row + 1, col + 1)) {
            int cnt1 = (grid[row][col] + grid[row+1][col] + grid[row+1][col+1]);
            int cnt2 = (grid[row][col] + grid[row][col+1] + grid[row+1][col+1]);
            int cnt3 = (grid[row][col+1] + grid[row+1][col+1] + grid[row+1][col]);
            int cnt4 = (grid[row][col] + grid[row+1][col] + grid[row][col+1]);

            maxCnt = Math.max(cnt1, cnt2);
            maxCnt = Math.max(maxCnt, cnt3);
            maxCnt = Math.max(maxCnt, cnt4);
            return maxCnt;
        } else return maxCnt;
    }


    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxCnt = 0;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int n1 = threeHorizon(i, j);
                int n2 = threeVertical(i, j);
                int n3 = curve(i, j);
                maxCnt = Math.max(n1, maxCnt);
                maxCnt = Math.max(n2, maxCnt);
                maxCnt = Math.max(n3, maxCnt);
            }
        }

        System.out.println(maxCnt);
    }
}