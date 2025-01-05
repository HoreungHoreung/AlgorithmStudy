import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int A, B, V;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		int day = 1;

		if (V <= A)
			System.out.println(1);
		else {
			if ((V - A) % (A - B) == 0) {
				System.out.println((V - A) / (A - B) + 1);
			} else {
				System.out.println((V - A) / (A - B) + 2);
			}
		}
	}
}
