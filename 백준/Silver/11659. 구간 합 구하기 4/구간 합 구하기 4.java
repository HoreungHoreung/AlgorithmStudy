import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer sT = new StringTokenizer(br.readLine());
		int suNo = Integer.parseInt(sT.nextToken());
		int quizNo = Integer.parseInt(sT.nextToken());

		long[]S = new long[suNo + 1];
		sT = new StringTokenizer(br.readLine());
		for (int i = 1; i <= suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(sT.nextToken());

		}
		for (int q = 0; q < quizNo; q++) {
			sT = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(sT.nextToken());
			int j = Integer.parseInt(sT.nextToken());
			System.out.println(S[j] - S[i-1]);
		}


	}
}
