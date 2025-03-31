import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //기존 Heap은 기본이 최소힙 ->  Comparator를 사용하여 최대힙으로 변환
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                sb.append(maxHeap.isEmpty() ? 0 : maxHeap.poll());
                sb.append("\n");
            } else {
                maxHeap.offer(x);
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
