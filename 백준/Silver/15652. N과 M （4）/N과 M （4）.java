import java.util.*;
import java.io.*;


public class Main {
    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void repeatedCombination(int start, int cnt) {
        if(cnt == M){
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= N; i++) {
            arr[cnt] = i;
            repeatedCombination(i, cnt + 1);
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

        repeatedCombination(1, 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
