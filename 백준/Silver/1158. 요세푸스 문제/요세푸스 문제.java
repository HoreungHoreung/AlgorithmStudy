import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 1;
        while(!deque.isEmpty()) {
            int curr = deque.pollFirst();
            if(index != K) {
                deque.addLast(curr);
            } else {
                sb.append(Integer.toString(curr) + ", ");
            }
            index = (index % K) + 1;
        }
        sb.append(">");
        sb.delete(sb.length() - 3, sb.length() - 1);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
