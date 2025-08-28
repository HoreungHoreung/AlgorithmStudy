import java.io.*;
import java.util.*;
public class Main {
    private static int N;
    private static int max = 0;
    private static int[] nums;
    private static boolean[] visited;
    private static List<int[]> permutations = new ArrayList<>();
//    private static void recursive(int depth, int prev, int sum) {
//        boolean done = true;
//        for(boolean v : visited) {
//            if(!v){
//                done = false;
//                break;
//            }
//         }
//
//        if(done) {
//            max = Math.max(max, sum);
//            System.out.println("max: " + max);
//            System.out.println("==================");
//            return;
//        }
//
//        for(int i = 0; i < N; i++) {
//            if(visited[i]) continue;
//            visited[i] = true;
//            recursive(depth + 1, i,sum + Math.abs(nums[prev] - nums[i]));
//            visited[i] = false;
//        }
//    }


    private static void permutation(int depth, int result[]) {
        if(depth == N) {
            int[] output = new int[N];
            for(int i = 0; i < N; i++) {
                output[i] = result[i];
            }
            permutations.add(output);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[depth] = nums[i];
            permutation(depth + 1, result);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new int[N]);
//        for(int[] p : permutations) {
//            for(int i : p) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        for(int i = 0; i < N; i++) {
//            visited[i] = true;
//            recursive(1, i, )
//        }

        for(int[] p : permutations) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(p[i] - p[i + 1]);
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }
}
