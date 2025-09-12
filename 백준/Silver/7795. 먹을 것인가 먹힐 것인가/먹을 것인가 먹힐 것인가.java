import java.io.*;
import java.util.*;
// 11:45 시작
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(A);

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(B);

            long ans = 0;

            for (int i = 0; i < A.length; i++) {
                int a = A[i];

                // B에서 a 이상이 처음 나오는 위치 = a보다 작은 원소 개수
                int left = 0, right = B.length; // [left, right)
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (B[mid] < a) left = mid + 1;
                    else right = mid;
                }
                ans += left; // a보다 작은 B의 원소 개수
            }

            System.out.println(ans);
        }
        br.close();
    }
}