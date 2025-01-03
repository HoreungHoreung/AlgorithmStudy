import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static String isPallindrome(int[] nums) {
		int arrLength = (int)nums.length;
		for (int i = 0; i < arrLength / 2; i++) {
			int j = arrLength - i - 1;
			if (nums[i] != nums[j]) {
				return "no";
			}
		}
		return "yes";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		String line;
		while (!(line = br.readLine()).equals("0")) {
			char[] ch = line.toCharArray();
			int[] nums = new int[ch.length];

			for (int i = 0; i < nums.length; i++) {
				nums[i] = ch[i] - '0';
			}

			System.out.println(isPallindrome(nums));
		}
	}
}
