import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] nums;
    private static int[]visited = new int[10001];
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<String> output = new HashSet<>();

    private static void permutation(int cnt) {
        if(cnt == M) {
            String key = Arrays.toString(arr);
            if(output.contains(key)) return;
            output.add(key);
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int num : nums) {
            if(visited[num] != 0) {
                arr[cnt] = num;
                visited[num]--;
                permutation(cnt + 1);
                visited[num]++;
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
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int currNum = Integer.parseInt(st.nextToken());
            nums[i] = currNum;
            visited[currNum]++;
        }

        Arrays.sort(nums);

        permutation(0);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
