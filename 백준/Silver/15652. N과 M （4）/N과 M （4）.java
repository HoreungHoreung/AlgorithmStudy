import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    private static void repeatedCombination(int[] answer, int cnt, int start, int N, int M) {
        if(cnt == M) {
            for(int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N ; i++) {
            answer[cnt] = i;
            repeatedCombination(answer, cnt + 1, i, N, M);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] answer = new int[M];

        repeatedCombination(answer, 0, 1, N , M);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
