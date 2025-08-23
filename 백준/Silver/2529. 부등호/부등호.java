import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static String[] signs;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    static boolean isValid(char sign, int a, int b) {
        if (sign == '<') return a < b;
        else return a > b;
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(signs[depth - 1].charAt(0), num.charAt(depth - 1) - '0', i)) {
                    visited[i] = true;
                    dfs(depth + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = br.readLine().split(" ");

        dfs(0, "");
        Collections.sort(results);

        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }
}