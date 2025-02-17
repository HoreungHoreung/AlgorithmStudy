import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] visited = new int[10001];
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<String> hashSet = new HashSet<>();

    private static void permutation(int cnt) {
        if(cnt == M) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++) {
                temp.append(arr[i]).append(" ");
            }
            if(hashSet.contains(temp.toString())) {
                return;
            } else {
                for(int i = 0; i < M; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                hashSet.add(temp.toString());
                return;
            }
        }
        for(int i = 0; i < N; i++) {
            if(visited[nums[i]] == 0) continue;
            visited[nums[i]]--;
            arr[cnt] = nums[i];
            permutation(cnt + 1);
            visited[nums[i]]++;
        }
    }

    public static void main(String[] args) throws IOException {
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

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
