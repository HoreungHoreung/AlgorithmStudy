import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int N;
    private static int[] output;

    private static void dfs(int curr) {
        visited[curr] = true;

        for(int next : graph.get(curr)) {
            if(!visited[next]) {
                output[next] = curr;
                dfs(next);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        output = new int[N + 1];


        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for(int i = 2; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}