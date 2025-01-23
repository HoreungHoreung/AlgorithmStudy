import java.util.Scanner;
public class Main {
    static void printStar(int n) {
        if(n == 0) return;
        printStar(n-1);
        for(int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printStar(num);
    }
}