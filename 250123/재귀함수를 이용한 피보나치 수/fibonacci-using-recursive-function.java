import java.util.Scanner;
public class Main {
    static int fib(int n) {
        if(n == 1) return 1;
        if(n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        System.out.println(fib(sc.nextInt()));
    }
}