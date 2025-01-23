import java.util.Scanner;
public class Main {
    static int F(int N) {
        int cnt = 0;
        if(N == 1) return 0;
        if(N % 2 == 0) N /= 2;
        else N /= 3;

        return 1 + F(N);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(F(num));
    }
}