import java.util.*;
import java.io.*;

public class Main{
    private static final int LIMIT = 1299709;
    private static boolean[] isPrime = new boolean[LIMIT + 1];

    private static void eratos() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <=  Math.sqrt(LIMIT); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        eratos();

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(isPrime[k]) {
                System.out.println(0);
            } else {
                int left = k - 1;
                int right = k + 1;
                while(left > 1 && !isPrime[left]) {
                    left--;
                }

                while(right <= LIMIT && !isPrime[right]) {
                    right++;
                }

                System.out.println(right - left);
            }
        }
    }
}

/*
1 2 3 4 5 6 7 8 9

 */