import java.util.Scanner;
public class Main {
    static void naturalOrder(int n) {
        if(n == 0) return;
        int out = n;
        naturalOrder(--n);
        System.out.print(out + " ");

        
    }
    static void reverseOrder(int n) {
        if(n == 0) return;
        System.out.print(n + " ");
        reverseOrder(--n);
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