import java.io.*;
import java.util.*;

public class Main {
    static class Egg {
        int durability, weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        boolean isBroken() {
            return durability <= 0;
        }
    }

    private static int N;
    private static int maxBroken = 0;
    private static Egg[] eggs;

    private static void dfs(int idx) {
        if (idx == N) {
            int cnt = 0;
            for (Egg egg : eggs) {
                if (egg.isBroken()) cnt++;
            }
            maxBroken = Math.max(maxBroken, cnt);
            return;
        }

        if (eggs[idx].isBroken()) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == idx || eggs[i].isBroken()) continue;

            hit = true;

            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            dfs(idx + 1);

            // 백트래킹 복원
            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;
        }

        if (!hit) {
            dfs(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(d, w);
        }

        dfs(0);

        System.out.println(maxBroken);
    }
}
