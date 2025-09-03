import java.io.*;
import java.util.*;

// 10:10 시작 ->
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //고양이 수 => 5000 C 2 = 1249,7500
        int K = Integer.parseInt(st.nextToken());

        int[] cats = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        // #1. 천만 정도의 경우의 수니까 백트랭킹 시도 시작 -> 10:17 -> 재귀깊이 천만이면 안됨 바로 포기 10:20
        // #2. 그리디겠지 -> 정렬 후

        Arrays.sort(cats);

        // 2 4 8 11 16 => 20
        // 3 4 5 6 7 9 => 10
        // 97 98 99 100 => 100
        int left = 0, right = N - 1, maxCnt = 0;
        while(left < right) {
//            System.out.println("left , right = " + left + " , " + right);
            if(cats[left] + cats[right] <= K) {
                left++;
                right--;

                maxCnt++;
            } else {
                right--;
            }
        }

        System.out.println(maxCnt);
    }
}
