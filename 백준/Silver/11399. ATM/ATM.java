import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            times.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(times);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int inSum = 0;
            for(int j = 0; j <= i; j++) {
                inSum += times.get(j);
            }
            sum += inSum;
        }

        bw.write(sum + " \n");
        br.close();
        bw.flush();
        bw.close();


    }
}
