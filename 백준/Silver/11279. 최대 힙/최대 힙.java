import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
           public int compare(Integer a, Integer b) {
               return b - a;
        }});

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
