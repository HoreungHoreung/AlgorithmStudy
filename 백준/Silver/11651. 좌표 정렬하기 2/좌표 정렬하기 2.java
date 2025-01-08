import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] numArr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            numArr[i][0] = Integer.parseInt(st.nextToken());
            numArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr, (x, y) -> {
            if(x[1] != y[1]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] arr : numArr) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}
