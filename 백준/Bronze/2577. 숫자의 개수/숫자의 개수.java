import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		//int [] nums = new int[3];
		int product = 1;
		for (int i = 0; i < 3; i++) {
			product *= Integer.parseInt(br.readLine());
		}
		int[] count = new int[10];
		if (product == 0) {
			count[0] = 1;
		} else {
			while (product > 0) {
				int digit = product % 10;
				count[digit]++;
				product /= 10;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
		br.close();

	}
}
