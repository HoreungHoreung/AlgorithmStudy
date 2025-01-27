import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        LinkedList<Integer> deque = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        for(int i = 0; i < n * 3; i++) {
            deque.addLast(sc.nextInt());
        }

        for(int i = 0; i < t; i++) {
            int temp1 = deque.remove(n - 1);
            int temp2 = deque.remove(2 * n - 2);
            int temp3 = deque.removeLast();
            deque.add(n - 1, temp1);
            deque.add(2 * n - 1, temp2);
            deque.add(0, temp3);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(deque.pollFirst() + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(deque.pollFirst() + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(deque.pollFirst() + " ");
        }
    }
}