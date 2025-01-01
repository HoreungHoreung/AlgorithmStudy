import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean isPrime(int num) {
		if(num < 2) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int num = 0; num < N; num++) {
			nums[num] = Integer.parseInt(st.nextToken());
		}

		for (int num = 0; num < N; num++) {
			if(isPrime(nums[num])) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
