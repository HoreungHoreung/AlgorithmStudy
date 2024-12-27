import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.printf("%c\n%.2f\n%.2f", c, a, b);
    }
}