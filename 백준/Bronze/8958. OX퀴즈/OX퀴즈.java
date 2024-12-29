import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int max_cnt = 0;
			int cnt = 0;
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					cnt += 1;
					max_cnt += cnt;
				}
				else {
					cnt = 0;
				}

			}
			System.out.println(max_cnt);

		}

	}
}
