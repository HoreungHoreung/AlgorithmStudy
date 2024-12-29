import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		int[] alphabets_pos = new int[26];
		Arrays.fill(alphabets_pos, -1);

		for (int i = 0; i < word.length(); i++) {
			char n = word.charAt(i);
			int n_pos = (int) n - 97;
			if (alphabets_pos[n_pos] == -1) {
				alphabets_pos[n_pos] = i;
			}
		}

		for (int num : alphabets_pos) {
			System.out.print(num + " ");
		}
        br.close();

	}
}
