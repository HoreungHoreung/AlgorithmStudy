import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        int T = Integer.parseInt(br.readLine());
        boolean[][] visited;

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            Deque<int[]> deque = new ArrayDeque<>();
            visited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            deque.addLast(new int[] {startX, startY, 0});
            visited[startX][startY] = true;

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            boolean turnEnd = false;
            while(!deque.isEmpty()) {
                int[] curr = deque.pollFirst();
                int currX = curr[0];
                int currY = curr[1];
                int currCnt = curr[2];

                if(currX == targetX && currY == targetY) {
                    System.out.println(currCnt);
                    turnEnd = true;
                    break;
                }

                for(int i = 0; i < 8; i++) {
                    int newX = currX + dx[i];
                    int newY = currY + dy[i];

                    if((0 <= newX && newX < N && 0 <= newY & newY < N) && !(visited[newX][newY])) {
                        deque.addLast(new int[] {newX, newY, currCnt + 1});
                        visited[newX][newY] = true;
                    }
                }
            }
            if(turnEnd) continue;
        }
    }
}
