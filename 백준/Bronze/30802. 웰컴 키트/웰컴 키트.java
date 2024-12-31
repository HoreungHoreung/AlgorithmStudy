import java.io.*;
import java.nio.Buffer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine());
		String[] sizeStr = br.readLine().split(" ");
		int[] sizes = new int[6];
		for (int i = 0 ; i < 6; i++) {
			sizes[i] = Integer.parseInt(sizeStr[i]);
		}

		String[] tp = br.readLine().split(" ");
		int T = Integer.parseInt(tp[0]);
		int P = Integer.parseInt(tp[1]);

		int shirts = 0;

		for (int i = 0; i < sizes.length; i++) {
			if ((sizes[i] % T) == 0) {
				shirts += (sizes[i] / T);
			} else if(sizes[i] > 0) {
				shirts += ((sizes[i] / T) + 1);
			} else {
				continue;
			}
		}
		System.out.println(shirts);
		System.out.println(N/P + " " + N%P);
	}
}
