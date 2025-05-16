import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 기존 휴게소 수
        int M = Integer.parseInt(st.nextToken()); // 추가로 지을 수 있는 휴게소 수
        int L = Integer.parseInt(st.nextToken()); // 고속도로 길이

        List<Integer> rests = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rests.add(Integer.parseInt(st.nextToken()));
            }
        }
        rests.add(0);
        rests.add(L);
        Collections.sort(rests);

        int left = 1;
        int right = L;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 1; i < rests.size(); i++) {
                int dist = rests.get(i) - rests.get(i - 1);
                count += (dist - 1) / mid;
            }
            if (count > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
