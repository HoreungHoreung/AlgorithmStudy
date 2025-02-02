

import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static boolean[] visited = new boolean[10001];
    private static int[] arr;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    private static void permutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            int currNum = nums[i];
            if(visited[currNum]) continue;
            visited[currNum] = true;
            arr[cnt] = currNum;
            permutation(cnt + 1);
            visited[currNum] = false;
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
        permutation(0);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
