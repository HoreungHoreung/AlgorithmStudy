import java.nio.Buffer;
import java.util.Scanner;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		/*int min = 1000000;
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
		System.out.println(min + " " + max);*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");

		int max = Integer.parseInt(numbers[0]);
		int min = Integer.parseInt(numbers[0]);

		for (int i = 1; i < N; i++) {
			max = Math.max(max, Integer.parseInt(numbers[i]));
			min = Math.min(min, Integer.parseInt(numbers[i]));
		}

		System.out.println(min + " " + max);
		br.close();

	}
}
