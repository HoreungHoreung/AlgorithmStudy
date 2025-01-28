import java.util.*;

public class Main {
    private static ArrayList<Integer> array = new ArrayList<>();
    private static int n, k;

    private static void print() {
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    private static void choose(int currNum) {
        if(currNum == n + 1) {
            print();
        return;
        }
        for(int i = 1; i < k + 1; i++) {
            array.add(i);
            choose(currNum + 1);
            array.remove(array.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        choose(1);
    }
}