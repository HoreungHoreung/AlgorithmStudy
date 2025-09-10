import java.io.*;
import java.util.*;
// 10:40 시작 ->
/*
    1. 완전탐색 -> O(N^3) 이상 -> 시간초과
    2. 연속된 수들의 부분합 -> 투포인터 가능 => 10:45
    3. DP 가능? -> 모르겠으니까 성현이형한테 물어보자 ㅋ
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int sum = 0;
        int cnt = N + 1;

        while(true) {
            if(sum >= S) {
                cnt = Math.min(cnt, right - left);
                sum -= nums[left++];
            } else {
                if(right == N) break;
                sum += nums[right++];
            }
        }

        System.out.println(cnt == N + 1 ? 0 : cnt);
        br.close();
    }
}
