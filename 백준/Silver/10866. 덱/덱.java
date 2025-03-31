import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front" :
                    int num_push = Integer.parseInt(st.nextToken());
                    deque.offerFirst(num_push);
                    break;
                case "push_back" :
                    int num_back = Integer.parseInt(st.nextToken());
                    deque.offerLast(num_back);
                    break;
                case "pop_front" :
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
