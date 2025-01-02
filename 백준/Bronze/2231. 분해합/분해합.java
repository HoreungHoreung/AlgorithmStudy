import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] sum_arr = new int[10000001];

		for (int i = 1; i < N + 1; i++) {
			char[] cNum = Integer.toString(i).toCharArray();
			int sum = i;
			for (int j = 0; j < cNum.length; j++) {
				sum += (cNum[j] - '0');
			}
			if (sum_arr[sum] == 0) {
				sum_arr[sum] = i;
			} else {
				continue;
			}
		}
		System.out.println(sum_arr[N]);
	}
}
