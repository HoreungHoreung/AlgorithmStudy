import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int printOrder(int N, int M, ArrayList<Integer> printer) {
        int cnt = 0;
        while (!printer.isEmpty()) {
            boolean hasHihger = false;
            for(int i = 0; i < printer.size(); i++) {
                if (printer.get(0) < printer.get(i)) {
                    hasHihger = true;
                    break;
                }
            }

            if(hasHihger) {
                printer.add(printer.remove(0));
                M = (M - 1 + printer.size()) % printer.size();
            } else {
                printer.remove(0);
                cnt ++;

                if (M == 0) {
                    return cnt;
                }
                M--;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 1) st = new StringTokenizer(br.readLine());
            else st = new StringTokenizer(br.readLine(), " ");

            ArrayList<Integer> printer = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                printer.add(Integer.parseInt(st.nextToken()));
            }

            bw.write(String.valueOf(printOrder(N, M, printer)) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
