import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] box = new int[M][N];

        Deque<int[]> deque = new ArrayDeque<>();

        for(int row = 0; row < M; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) {
                    deque.addLast(new int[] {row, col});
                }
                box[row][col] = now;
            }
        }

        int day = 0;
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                int[] curr = deque.pollFirst();
                int currX = curr[0];
                int currY = curr[1];

                for(int j = 0; j < 4; j++) {
                    int newX = currX + dx[j];
                    int newY = currY + dy[j];

                    if((0 <= newX && newX < M && 0 <= newY && newY < N) && (box[newX][newY] == 0)) {
                        box[newX][newY] = 1;
                        deque.addLast(new int[] {newX, newY});
                    }
                }
            }
            day++;
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day - 1);
        br.close();
        bw.flush();
        bw.close();
    }
}