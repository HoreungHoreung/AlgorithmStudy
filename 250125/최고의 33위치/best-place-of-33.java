import java.util.*;
public class Main {
    public static int[][] grid;

    public static int getCoins(int row, int col) {
        int coin = 0;
        for(int i = row; i <= row + 2; i++) {
            for(int j = col; j <= col + 2; j++) {
                if(grid[i][j] == 1) coin++;
            }
        }
        return coin;
    }
     
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int maxCoin = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                int currCoin = getCoins(i, j);
                maxCoin = Math.max(maxCoin, currCoin);
            }
        }

        System.out.println(maxCoin);
    }
}