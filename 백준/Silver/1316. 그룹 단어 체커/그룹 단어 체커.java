import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) result++;
        }
        System.out.println(result);
    }

    private static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26];
        char prev = ' ';

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr != prev) {
                if (seen[curr - 'a']) {
                    return false; // 이미 등장했는데 다시 나타남
                }
                seen[curr - 'a'] = true;
            }
            prev = curr;
        }
        return true;
    }
}