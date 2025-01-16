import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            nameMap.put(name, i + 1);
            numberMap.put(i + 1, name);
        }

        for (int j = 0; j < M; j++) {
            String target = br.readLine();
            if (isNumeric(target)) bw.write(numberMap.get(Integer.parseInt(target)) + "\n");
            else bw.write(nameMap.get(target) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
