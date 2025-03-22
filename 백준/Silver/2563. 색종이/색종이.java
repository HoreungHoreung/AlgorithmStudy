import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[100][100];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int row = x; row < x + 10; row++) {
                for(int col = y; col < y + 10; col++) {
                    if(grid[row][col] != 1) answer++;
                    grid[row][col] = 1;
                }
            }
        }

        System.out.println(answer);
    }
}
