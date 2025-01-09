import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a = N / 5;
        int b = N % 5;

        while(true) {
            if (a == -1) {
                b = 0;
                break;
            }
            if (b % 3 == 0) {
                b /= 3;
                break;
            }
            a -= 1;
            b = (N - (5 * a));
        }
        System.out.println(a + b);
    }
}
