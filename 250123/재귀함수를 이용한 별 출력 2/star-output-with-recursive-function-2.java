import java.util.Scanner;
public class Main {
    static void star(int N) {
        if(N == 0) return;
        for(int i = 0; i < N; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
        star(N-1);
        for(int i = 0; i < N; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        star(num);
    }
}