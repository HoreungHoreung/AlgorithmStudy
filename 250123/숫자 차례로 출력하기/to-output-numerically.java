import java.util.Scanner;
public class Main {
    static void naturalOrder(int n) {
        if(n == 0) return;
        naturalOrder(n-1);
        System.out.print(n + " ");

        
    }
    static void reverseOrder(int n) {
        if(n == 0) return;
        System.out.print(n + " ");
        reverseOrder(n-1);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        naturalOrder(n);
        System.out.println();
        reverseOrder(n);
    }
}