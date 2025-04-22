import java.util.*;
import java.io.*;

public class Main {
    private static int[] answer;
    private static StringBuilder sb = new StringBuilder();

    private static void permutation(boolean[] visited, int cnt){
        if(cnt == answer.length) {
            for(int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[cnt] = i;
                permutation(visited, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        answer = new int[M];

        permutation(visited, 0);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
