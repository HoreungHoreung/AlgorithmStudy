import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] parts = br.readLine().split(" ");
			int[] sides = new int[3];

			for (int i = 0; i < 3; i++) {
				sides[i] = Integer.parseInt(parts[i]);
			}
			if (sides[0] == 0 || sides[1] == 0 || sides[2] == 0) {
				break;
			}
			Arrays.sort(sides);

			if ((sides[0] * sides[0]) + (sides[1] * sides[1]) == (sides[2] * sides[2])) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
