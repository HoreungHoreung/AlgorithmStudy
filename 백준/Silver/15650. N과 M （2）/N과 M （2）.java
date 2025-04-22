import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb;
    public static int[] answer;
    private static void permutation(boolean[] visited, int cnt, int start) {
        if(cnt == answer.length) {
            for(int i = 0; i < answer.length; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[cnt] = i;
                permutation(visited, cnt + 1, i + 1);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        boolean[] visited = new boolean[N + 1];

        permutation(visited, 0,  1);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
