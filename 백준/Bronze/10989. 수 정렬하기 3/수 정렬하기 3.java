import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄: N (수의 개수)
        int N = Integer.parseInt(br.readLine());

        // 카운팅 정렬을 위한 배열 초기화 (수의 범위는 1~10,000)
        int[] count = new int[10001];

        // N개의 수를 읽어 카운트 배열에 저장
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }

        br.close(); // BufferedReader 닫기

        // 카운트 배열을 기반으로 오름차순으로 출력
        for (int num = 1; num <= 10000; num++) {
            while (count[num] > 0) {
                bw.write(num + "\n");
                count[num]--;
            }
        }

        bw.flush(); // BufferedWriter의 내용을 출력
        bw.close(); // BufferedWriter 닫기
    }
}
