import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] kids = new int[N];
        for(int i = 0; i < N; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(kids); //키 오름차순

        int[] gap = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
            gap[i] = kids[i + 1] - kids[i];
        }

        Arrays.sort(gap); //오름차순 정렬 -> 키차이

        long result = 0;
        for(int i= 0; i < N - K; i++) {
            result += gap[i];
        }
        
        System.out.println(result);
        br.close();
    }
}
