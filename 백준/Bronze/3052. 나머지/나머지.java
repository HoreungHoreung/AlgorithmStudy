import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		int[] rest = new int[43];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			rest[num % 42] += 1;

		}
		int cnt = 0;
		for (int i = 0; i < rest.length; i++) {
			if (rest[i] != 0) {
				cnt += 1;

			}
		}
		System.out.println(cnt);
	}
}
