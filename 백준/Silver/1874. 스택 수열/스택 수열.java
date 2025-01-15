import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        ArrayList<Character> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int num = 1; // stack에 추가될 숫자
        int cnt = 0; //sequnce 리스트에서 현재 몇 번째 값을 처리하고 있는지

        while (cnt < n) {
            if ((!stack.isEmpty()) && (stack.get(stack.size() - 1)) == sequence[cnt]) {
                stack.pop();
                output.add('-');
                cnt += 1;
            } else if(num <= n) {
                stack.add(num);
                output.add('+');
                num += 1;
            } else break;
        }

        if (stack.size() == 0) {
            for (char elem : output) {
                bw.write(elem + "\n");
            }
        } else bw.write("NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
