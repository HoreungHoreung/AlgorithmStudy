import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(nums, (a, b) -> b - a);

        System.out.println(nums.get(N - 1));

    }
}
