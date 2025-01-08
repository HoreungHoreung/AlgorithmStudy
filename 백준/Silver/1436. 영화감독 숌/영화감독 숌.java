import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        br.close();

        int count = 0;
        int number = 666;

        while (true) {
            if (Integer.toString(number).contains("666")) {
                count += 1;
            }
            if (count == N) break;
            number += 1;

        }

        bw.write(Integer.toString(number));
        bw.flush();
        bw.close();

    }
}
