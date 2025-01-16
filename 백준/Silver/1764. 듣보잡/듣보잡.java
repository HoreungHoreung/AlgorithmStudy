import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> noHeard = new HashSet<>();
        HashSet<String> noSeen = new HashSet<>();

        for(int i = 0; i < N; i++) {
            noHeard.add(br.readLine());
        }
        for (int j = 0; j < M; j++) {
            noSeen.add(br.readLine());
        }

        noHeard.retainAll(noSeen);

        String[] output = noHeard.toArray(new String[0]);
        Arrays.sort(output);

        bw.write(output.length + "\n");
        for(String name : output) {
            bw.write(name + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
