
import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    private static void repeatedPermutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[cnt] = nums[i];
            repeatedPermutation(cnt + 1);
        }
    }

    private static void repeatedCombination(int start, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++) {
            arr[cnt] = nums[i];
            repeatedCombination(i ,cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
//        repeatedPermutation(0);
        repeatedCombination(0, 0);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
