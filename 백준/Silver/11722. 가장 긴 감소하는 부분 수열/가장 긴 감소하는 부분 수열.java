import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[N];

        int maxCnt = 1;
        for(int i = 0; i < N; i++) {
            length[i] = 1;
            for(int j = 0; j < i; j++) {
                if(numbers[j] > numbers[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }

        for(int num : length) {
            maxCnt = Math.max(maxCnt, num);
        }

        System.out.println(maxCnt);
    }
}
