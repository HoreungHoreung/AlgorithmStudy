import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static int[] arr;

    private static void permutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N + 1];
        arr = new int[M];

        sc.close();

        permutation(0);
    }

}
