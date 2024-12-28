import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        char first = sc.next().charAt(0);
        char second = sc.next().charAt(0);
        
        int a = (int) first;
        int b = (int) second;

        System.out.print((a + b) + " " + (a > b ? a - b : b - a));
    }
}