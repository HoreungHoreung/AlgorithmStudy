import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        public static final int MAX_NUM = 1000;
    public static int n, m;

    public static ArrayList<Integer>[] graph = new ArrayList[MAX_NUM + 1];
    public static boolean[] visited = new boolean[MAX_NUM + 1];
    public static int vertexCnt = 0;

    public static void DFS(int vertex) {
        for(int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);
            if(!visited[currV]) {
                vertexCnt ++;
                visited[currV] = true;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        visited[1] = true;
        DFS(1);

        bw.write(vertexCnt + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    }
}