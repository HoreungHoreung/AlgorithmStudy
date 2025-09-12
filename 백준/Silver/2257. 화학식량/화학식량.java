import java.io.*;
import java.util.*;
// 11:00 시작 -> 11:40 종료
/*
    1. 입력된 분자식의 길이만큼 순회
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chemical = br.readLine();
        int length = chemical.length();

        //각 원자에 해당하는 화학식량
        Map<Character, Integer> value = new HashMap<>();
        value.put('H', 1);
        value.put('C', 12);
        value.put('O', 16);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < length; i++) {
            char c = chemical.charAt(i);
            if(c == '(') {
                stack.offerLast(-1);
            } else if(c == ')') {
                int sum = 0;
                while(!stack.isEmpty() && stack.peekLast() != -1) {
                    sum += stack.pollLast();
                }
                stack.pollLast();
                stack.offerLast(sum);
            } else if(c == 'H' || c == 'C' || c == 'O') {
                stack.offerLast(value.get(c));
            } else {
                int cnt = c - '0';
                int top = stack.pollLast();
                stack.offerLast(top * cnt);
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) answer += stack.pollLast();
        System.out.println(answer);
        br.close();
    }
}
