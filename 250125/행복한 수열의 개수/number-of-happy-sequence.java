import java.util.*;

public class Main {
    
    public static int[][] grid1;
    public static int[][] grid2;
    
    public static boolean isHappy(int[] currNums, int m) {
        int sameNum = currNums[0];
        int sameCnt = 1;
        for(int i = 1; i < currNums.length; i++){
            if(sameNum == currNums[i]) {
                sameCnt++;
                if(sameCnt >= m) return true;
            }
            else{
                sameNum = currNums[i];
                sameCnt = 1;
            }
        }
        return sameCnt >= m;
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        grid1 = new int[n][n];
        grid2 = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid1[i][j] = sc.nextInt();
                grid2[j][i] = grid1[i][j];
            }
        }

        int happys = 0;

        for(int i = 0; i < n; i++) {
            if(isHappy(grid1[i], m)) happys++;
        }

        for(int j = 0; j < n; j++) {
            if(isHappy(grid2[j], m)) happys++;
        }

        System.out.println(happys);
    }
}