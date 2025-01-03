import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		// TestCase number
		//int T = Integer.parseInt(st.nextToken());
		int T = sc.nextInt();

		//호수는 -1 해야함
		int[][] apartment = new int[15][14];
		for (int ho = 0; ho < 14; ho++) {
			apartment[0][ho] = ho + 1;
		}

		for (int cheng = 1; cheng <= 14; cheng++) {
			for (int ho = 0; ho < 14; ho++) {
				for (int target = 0; target <= ho; target++) {
					apartment[cheng][ho] += apartment[cheng-1][target];
				}
			}
		}

		for (int t = 0; t < T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(apartment[k][n-1]);

		}
	}
}
