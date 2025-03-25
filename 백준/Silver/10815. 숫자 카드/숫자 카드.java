import java.util.*;
import java.io.*;

public class Main {
    private static int[] have;
    private static boolean hasCard(int target) {
        int start = 0;
        int end = have.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(have[mid] == target) return true;
            else if(have[mid] <= target) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
//        if(have[start] == target || have[end] == target) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        have = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(have);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        for(int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
//            System.out.println(now);
            if(hasCard(now)) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }
}
