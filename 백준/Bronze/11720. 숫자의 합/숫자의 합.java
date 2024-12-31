import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String sNum = br.readLine();

		char[] cNum= sNum.toCharArray();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (cNum[i] - 48);
		}

		System.out.println(sum);

	}
}
