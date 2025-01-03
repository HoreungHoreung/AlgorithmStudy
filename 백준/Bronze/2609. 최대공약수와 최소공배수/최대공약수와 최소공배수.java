import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int max_divisor = 0;
		//int min_multiplier = 1000000000;
		for (int i = 1; i < Math.min(A, B) + 1; i++) {
			if ((A % i == 0) && (B % i == 0) && (i > max_divisor)) {
				max_divisor = i;
			}
		}

		System.out.println(max_divisor);
		System.out.println(A*B/max_divisor);
	}
}
