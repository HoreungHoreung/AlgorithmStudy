import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().split(" ");
		br.close();
		int cnt = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i] != "") {
				cnt += 1;
			}
		}
		System.out.print(cnt);
	}
}