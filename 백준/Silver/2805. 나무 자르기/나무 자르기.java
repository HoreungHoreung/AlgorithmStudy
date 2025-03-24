import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int left = 1;
       int right = -1;

       int[] trees = new int[N];
       st = new StringTokenizer(br.readLine());
       for(int i = 0; i < N; i++) {
           trees[i] = Integer.parseInt(st.nextToken());
           right = Math.max(right, trees[i]);
       }

       int mid = (left + right) / 2;

       while(left <= right) {
           mid = (left + right) / 2;
           long answer = 0;
           for(int i = 0; i < N ;i++) {
               if(trees[i] > mid) {
                   answer += trees[i] - mid;
               }
               if(answer > M) {
                   break;
               }
           }
           /*
           1 20 -> 10 / 11 20 -> 15 / 12 20 -> 16 / 12 19 -> 15 / 13 19 -> 16 / 13 18 -> 15 / 14 18 -> 16 / 14 17 -> 15 /
           15 17 -> 16 / 15 16 -> 15 / 16 16 -> 15
            */

           if(answer >= M) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }

       System.out.println(right);

    }
}
