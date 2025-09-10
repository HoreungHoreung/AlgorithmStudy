import java.io.*;
import java.util.*;
//10:00 시작 -> 
public class Main {
    static int N;
    static int[][] ability;
    static boolean[] pick; // true: 스타트, false: 링크
    static int answer = Integer.MAX_VALUE;

    static void dfs(int depth) {
        if (depth == N) {
            // 두 팀이 모두 비어있지 않은지 확인
            int cntStart = 0, cntLink = 0;
            for (int i = 0; i < N; i++) {
                if (pick[i]) cntStart++; else cntLink++;
            }
            if (cntStart == 0 || cntLink == 0) return;

            int startSum = 0, linkSum = 0;
            // 같은 팀끼리의 시너지 합산 (i < j만 보면 양방향 모두 더함)
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (pick[i] && pick[j]) { // 둘다 start 일때
                        startSum += ability[i][j] + ability[j][i];
                    } else if (!pick[i] && !pick[j]) { //둘다 link 일때
                        linkSum += ability[i][j] + ability[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(startSum - linkSum));
            return;
        }

        // idx 사람을 스타트 팀에 배정
        pick[depth] = true;
        dfs(depth + 1);

        // idx 사람을 링크 팀에 배정
        pick[depth] = false;
        dfs(depth + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        ability = new int[N][N];
        pick = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
        br.close();
    }
}