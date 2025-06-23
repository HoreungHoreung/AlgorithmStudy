import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int count = 0;
    private static int[] col; //col[i] = i번째 행에서 퀸이 위치한 열의 번호
    
    
    private static boolean canAttack(int row) {
        for(int i = 0; i < row; i++) {
            //같은 열 or 대각선일때 -> 불가
            if (col[row] == col[i] || Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
    
    private static void dfs(int row) {
        if(row == N) {
            count++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            col[row] = i;
            if(canAttack(row)) {
                dfs(row + 1);
            }
        }
    }    
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        col = new int[N];
        
        dfs(0);
        System.out.println(count);
    }
}