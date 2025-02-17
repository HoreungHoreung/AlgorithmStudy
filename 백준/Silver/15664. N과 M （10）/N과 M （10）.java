import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<String> hashSet = new HashSet<>();

    private static void combination(int start, int cnt) {
        if(cnt == M) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++) {
                temp.append(arr[i]).append(" ");
            }
            if(hashSet.contains(temp.toString())) {
                return;
            }else {
                hashSet.add(temp.toString());
                for(int i = 0; i < M; i++) {
                    sb.append(arr[i]).append(" ");
                }
                sb.append("\n");
                return;
            }
        }
        for(int i = start; i < N; i++) {
            arr[cnt] = nums[i];
            combination(i + 1, cnt + 1);
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
        combination(0, 0);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
