import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static boolean[] visited = new boolean[10001];
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    private static void repeatedCombination(int start, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            arr[cnt] = nums[i];
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
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        repeatedCombination(0, 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
