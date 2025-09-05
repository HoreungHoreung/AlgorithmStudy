import java.io.*;
import java.util.*;

// 11:20 시작 -> 11:50 종료
public class Main {
    private static int V, E, P;
    private static int[][] grid;
    private static final int INF = Integer.MAX_VALUE;
    private static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i = 1; i <= V; i++) {
            //방문하지 않은 노드중 최소거리 선택
            int u = -1, min = INF; // u => 노드, min => 거리

            for(int j = 1; j <= V; j++) {
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            if(u == -1) break;
            visited[u] = true;

            for(int v = 1; v <= V; v++) {
                if(!visited[v] && grid[u][v] < INF) {
                    if(dist[v] > dist[u] + grid[u][v]) {
                        dist[v] = dist[u] + grid[u][v];
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        grid = new int[V + 1][V + 1];

        for(int[] g : grid) { //처음엔 모두 못감
            Arrays.fill(g, INF);
        }

//        // 자신으로의 거리는 0
//        for(int i = 1; i <= V; i++) {
//            grid[i][i] = 0;
//        }

        for(int i = 0; i < E; i++) { //양방향 그래프 주의
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            grid[from][to] = dist;
            grid[to][from] = dist;
        }

        int[] distFrom1 = dijkstra(1);
        int[] distFromP = dijkstra(P);

        int direct = distFrom1[V];
        int viaGunwoo = (distFrom1[P] + distFromP[V]);

        if(direct == viaGunwoo) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}
