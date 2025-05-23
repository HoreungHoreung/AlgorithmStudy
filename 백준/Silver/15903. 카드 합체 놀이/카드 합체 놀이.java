import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            minHeap.offer(Long.parseLong(st.nextToken()));
        }

        while(m-- > 0) {
            long num1 = minHeap.poll();
            long num2 = minHeap.poll();

            long sum = num1 + num2;

            minHeap.offer(sum);
            minHeap.offer(sum);
        }

        long sum = 0;
        while(!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        br.close();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
