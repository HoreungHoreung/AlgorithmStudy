import java.util.Scanner;
public class Main {
    static void flower(int N) {
        if(N == 0) return;
        System.out.print(N + " ");
        flower(N - 1);
        System.out.print(N + " ");

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        flower(num);
        
    }
}