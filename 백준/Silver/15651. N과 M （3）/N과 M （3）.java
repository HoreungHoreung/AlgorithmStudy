import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    static void repeatedPermutation(int[] answer, int cnt, int N, int M) {
        if(cnt == M) {
            for(int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            answer[cnt] = i;
            repeatedPermutation(answer, cnt + 1, N, M);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] answer = new int[M];
        repeatedPermutation(answer, 0, N, M);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
