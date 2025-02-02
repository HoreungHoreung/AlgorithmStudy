import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

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

    private static void repeatedPermutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            arr[cnt] = i;
            repeatedPermutation(cnt + 1);
        }
    }

    private static void combination(int start, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    private static void repeatedCombination(int start, int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[cnt] = i;
            repeatedCombination(i, cnt+ 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new int[M];

//        permutation(0);
//        combination(1, 0);
//        repeatedPermutation(0);
        repeatedCombination(1, 0);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
