import java.util.*;
import java.io.*;
public class Main {
    public static class Node {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    private static int V, E, startV;
//    private static int[][] grid;
    private static List<List<Node>> graph;
    private static int[] distance;
    private static boolean[] visited;

    private static void dijkstra(int start) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.weight, n2.weight);
            }
        });
        distance[start] = 0;
        minHeap.offer(new Node(start, 0));

        while(!minHeap.isEmpty()) {
            Node currNode = minHeap.poll();
            int curr = currNode.to;
            if(visited[curr]) continue;
            visited[curr] = true;

            for(Node neighbor : graph.get(curr)) {
                int to = neighbor.to;
                int weight = neighbor.weight;

                if(!visited[to] && distance[to] > distance[curr] + weight) {
                    distance[to] = distance[curr] + weight;
                    minHeap.offer(new Node(to, distance[to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];

        //distance 테이블 초기화 (MAX_VALUE)
        for(int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //graph 초기화
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        dijkstra(startV);

        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}
