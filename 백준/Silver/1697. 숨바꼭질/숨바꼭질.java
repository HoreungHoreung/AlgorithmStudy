import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        if (N == K) { // 이미 같은 위치면 0초
            System.out.println(0);
            return;
        }

        // BFS를 위한 큐 및 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001]; // 방문 배열
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curr = now[0], time = now[1];

            // 이동 가능한 세 가지 경우
            int[] nextMoves = {curr - 1, curr + 1, curr * 2};

            for (int next : nextMoves) {
                if (next == K) { // ✅ 동생 위치에 도달하면 반환
                    System.out.println(time + 1);
                    return;
                }

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.add(new int[]{next, time + 1});
                    visited[next] = true;
                }
            }
        }
    }
}