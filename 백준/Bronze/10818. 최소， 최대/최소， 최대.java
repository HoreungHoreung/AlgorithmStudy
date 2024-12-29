import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int min = 1000000;
		int max = -1000000;

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		System.out.println(min + " " + max);
	}
}
