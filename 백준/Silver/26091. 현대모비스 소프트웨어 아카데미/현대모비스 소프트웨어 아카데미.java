import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] people = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int cnt = 0;
        // 3 3 5 5 6 7
        int left = 0;
        int right = N - 1;
//        if((N == 1)) {
//            System.out.println(cnt);
//            return;
//        }

        while(left < right) {
            int num = people[left] + people[right];
            if(num >= M) {
                cnt++;
                left++;
                right--;
            } else {
                left++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
