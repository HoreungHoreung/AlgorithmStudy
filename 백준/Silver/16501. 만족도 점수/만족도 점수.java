import java.io.*;
import java.util.*;

public class Main {
    static int[] a = new int[8];
    static boolean[] used = new boolean[8];
    static int[] pairSum = new int[4]; // 각 2인 팀의 합
    static int bestDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) a[i] = Integer.parseInt(st.nextToken());

        dfs(0);
        // 만족도 하한 = 1 - bestDiff/20 = (20 - bestDiff)/20
        int k = 20 - bestDiff; // 0..20
        // k/20이 0.1 단위면(k 짝수) 소수1째자리, 아니면 2째자리
        if (k % 2 == 0) {
            System.out.printf("%.1f%n", k / 20.0);
        } else {
            System.out.printf("%.2f%n", k / 20.0);
        }
    }

    // 8명 완전 매칭(4쌍) 만들기
    static void dfs(int formedPairs) {
        if (formedPairs == 4) {
            // 4팀의 합을 정렬하고 (s0,s1), (s2,s3)로 경기를 붙였을 때의 최대 차를 취함
            int[] s = pairSum.clone();
            Arrays.sort(s);
            int diff = Math.max(Math.abs(s[1] - s[0]), Math.abs(s[3] - s[2]));
            if (diff < bestDiff) bestDiff = diff;
            return;
        }
        // 첫 번째 미사용 인덱스 i 고정
        int i = 0;
        while (i < 8 && used[i]) i++;
        used[i] = true;
        for (int j = i + 1; j < 8; j++) {
            if (used[j]) continue;
            used[j] = true;
            pairSum[formedPairs] = a[i] + a[j];
            dfs(formedPairs + 1);
            used[j] = false;
        }
        used[i] = false;
    }
}