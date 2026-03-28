import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(i == 0) {
                maxDp[0] = minDp[0] = n0;
                maxDp[1] = minDp[1] = n1;
                maxDp[2] = minDp[2] = n2;
            } else {
                //이전 값
                int maxAhead0 = maxDp[0], maxAhead1 = maxDp[1], maxAhead2 = maxDp[2];
                int minAhead0 = minDp[0], minAhead1 = minDp[1], minAhead2 = minDp[2];

                //최댓값
                maxDp[0] = Math.max(maxAhead0, maxAhead1) + n0;
                maxDp[1] = Math.max(Math.max(maxAhead0, maxAhead1), maxAhead2) + n1;
                maxDp[2] = Math.max(maxAhead1, maxAhead2) + n2;

                //최솟값
                minDp[0] = Math.min(minAhead0, minAhead1) + n0;
                minDp[1] = Math.min(Math.min(minAhead0, minAhead1), minAhead2) + n1;
                minDp[2] = Math.min(minAhead1, minAhead2) + n2;

              }
        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        br.close();
        System.out.println(max + " " + min);
    }
}
