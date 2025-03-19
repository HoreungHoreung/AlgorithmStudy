import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Integer[] num1 = new Integer[N];
        Integer[] num2 = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        });

        Arrays.sort(num2, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return Integer.compare(b, a);
            }
        });

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += (num1[i] * num2[i]);
        }

        System.out.println(sum);


    }

}