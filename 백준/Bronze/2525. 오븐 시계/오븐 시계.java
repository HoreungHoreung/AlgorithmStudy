import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        int a = C / 60;
        int b = C % 60;

        int aa = (B + b) / 60;
        B = (B + b) % 60;
        A = (A + a + aa) % 24;

        System.out.println(A + " " + B);

    }

}
