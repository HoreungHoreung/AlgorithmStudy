import java.util.*;
public class Main {
    public static void main(String[] arsg) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        //카드덱 입력 및 생성
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        //카드 1장이 될 때까지 반복
        while(deque.size() != 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.pollFirst());
    }
}
