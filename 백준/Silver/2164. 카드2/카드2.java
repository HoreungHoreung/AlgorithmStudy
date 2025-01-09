import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }


        while(queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        bw.write(String.valueOf(queue.poll()));
        br.close();
        bw.flush();
        bw.close();

    } 
}
