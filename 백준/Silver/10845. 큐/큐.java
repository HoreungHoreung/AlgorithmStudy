import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.get(0) + "\n");
                        queue.remove(0);
                    }
                    break;

                case "size":
                    bw.write(queue.size() + "\n");
                    break;

                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;

                case "front":
                    bw.write((queue.isEmpty() ? -1 : queue.get(0)) + "\n");
                    break;

                case "back":
                    bw.write((queue.isEmpty() ? -1 : queue.get(queue.size() - 1)) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}