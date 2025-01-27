import java.util.*;
public class Main {
    public static Deque<Integer> deque = new LinkedList<>();
    //ArrayList<Integer> array2 = new ArrayList<>();
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        for(int i = 0; i < 2 * n; i++) {
            deque.addLast(sc.nextInt());
        }

        for(int i = 0; i < t; i++) {
            int temp = deque.pollLast();
            deque.addFirst(temp);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(deque.pollFirst() +  " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(deque.pollFirst() +  " ");
        }
    }
}