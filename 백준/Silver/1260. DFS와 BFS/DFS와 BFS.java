import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] grid;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int V) {
        visited[V] = true;
        sb.append((V + 1) + " ");

        for(int adj = 0; adj < N; adj++) {
            if(!visited[adj] && grid[V][adj] == 1) dfs(adj);
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V - 1);
        visited[V - 1] = true;
        sb.append(V + " ");

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int adj = 0; adj < N; adj++) {
                if(grid[curr][adj] == 1 && !visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                    sb.append((adj + 1) + " ");
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grid[a-1][b-1] = 1;
            grid[b-1][a-1] = 1;
        }

        sb = new StringBuilder();
        dfs(V-1);
        bw.write(sb.toString().trim() + "\n");

        visited = new boolean[N];

        sb = new StringBuilder();
        bfs(V);
        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}

