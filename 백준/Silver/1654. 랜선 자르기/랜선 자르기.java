import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[K];

        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        long length = 0;
        long max_length = nums[K - 1];
        long min_length = 1;

        while (min_length <= max_length) {
            long mid_length = (max_length + min_length) / 2;
            long cnt = 0;

            for (int num : nums) {
                cnt += (num / mid_length);
            }

            if (cnt >= N) {
                length = mid_length;
                min_length = mid_length + 1;
            } else {
                max_length = mid_length - 1;
            }
        }
        bw.write(length + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
