import java.util.Scanner;
public class Main {
    static int sumation(int N) {
        if(N == 1) return 1;

        return N + sumation(N - 1);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(sumation(num));

    }
}