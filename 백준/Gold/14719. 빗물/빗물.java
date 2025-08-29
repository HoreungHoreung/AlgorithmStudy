import java.io.*;
import java.util.*;

public class Main {
    private static int H, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); //높이
        W = Integer.parseInt(st.nextToken()); //가로
        int[] grid = new int[W];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            grid[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = W - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;

        while(left < right) {
            if(grid[left] < grid[right]) {
                // 왼쪽이 더 낮은 경우
                if(grid[left] >= leftMax) {
                    leftMax = grid[left];
                } else {
                    // 빗물이 고임
                    sum += leftMax - grid[left];
                }
                left++;
            } else {
                // 오른쪽이 더 낮거나 같은 경우
                if(grid[right] >= rightMax) {
                    rightMax = grid[right];
                } else {
                    // 빗물이 고임
                    sum += rightMax - grid[right];
                }
                right--;
            }
        }

        System.out.println(sum);
    }
}
