import java.util.*;
import java.io.*;
public class Main {
    private static int DFS(int vertex, int[][] graph, boolean[] visited, int cnt) {
        for(int currV = 1; currV < graph.length; currV++) {
            if(graph[vertex][currV] == 1 && !visited[currV]) {
                cnt++;
                visited[currV] = true;
                cnt = DFS(currV, graph, visited, cnt);
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        boolean[] visited = new boolean[N + 1];

        int cnt = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for(int i = 0; i < N + 1; i++) {
            graph[i][i] = 1;
        }

        bw.write(DFS(1, graph, visited, cnt) - 1 + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}