import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;

    public static StringBuilder sb = new StringBuilder();

    public static void permutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                arr[cnt] = i;
                visited[i] = true;
                permutation( cnt + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        permutation( 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
