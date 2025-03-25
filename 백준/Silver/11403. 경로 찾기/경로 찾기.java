import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] grid;
    private static StringBuilder sb = new StringBuilder();

    private static void bfs(int num) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(num);
        boolean[] visited = new boolean[N];

        while(!deque.isEmpty()) {
            int curr = deque.pollFirst();
            for(int i = 0; i < N; i++) {
                if(!visited[i] && grid[curr][i] == 1) {
                    deque.addLast(i);
                    visited[i] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        sb.append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N ;i++) {
            bfs(i);
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}