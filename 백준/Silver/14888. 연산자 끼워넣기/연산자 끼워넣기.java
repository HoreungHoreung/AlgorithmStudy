import java.util.*;
import java.io.*;

public class Main {
    private static int[] nums;
    private static int totalOps;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int operate(int curr, int cnt, int operation) {
        if(operation == 0) {
            curr += nums[cnt];
        } else if(operation == 1) {
            curr -= nums[cnt];
        } else if(operation == 2) {
            curr *= nums[cnt];
        } else {
            if(curr >= 0) {
                curr /= nums[cnt];
            } else {
                curr = ((curr * -1) / nums[cnt]) * (-1);
            }
        }
        return curr;
    }

    private static void permutation(int[] operations, int currNum, int cnt) {
        if(cnt == nums.length - 1) {
            MAX = Math.max(currNum, MAX);
            MIN = Math.min(currNum, MIN);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(operations[i] > 0) {
                operations[i] -= 1;
                permutation(operations, operate(currNum, cnt + 1, i), cnt + 1);
                operations[i] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] operations = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        permutation(operations, nums[0], 0);

        br.close();
        bw.write(String.valueOf(MAX));
        bw.newLine();
        bw.write(String.valueOf(MIN));
        bw.flush();
        bw.close();
    }
}