import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static boolean is_prime(int x) {

        for(int i = 2; i < (int)(Math.sqrt(x)) + 1; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i <= N; i++) {
            if (i == 1) continue;
            else {
                if (is_prime(i)) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
