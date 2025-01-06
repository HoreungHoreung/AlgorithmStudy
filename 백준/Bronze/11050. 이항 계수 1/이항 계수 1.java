import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int A = 1;
		int B = 1;
		int C = 1;

		for(int i = N; i > 0; i--) {
			A *= i;
		}

		for(int i = K; i > 0; i--) {
			B *= i;
		}

		for(int i = N - K; i > 0; i--) {
			C *= i;
		}
		System.out.print(A / (B * C));
	}
}
