import java.util.*;
public class Main {
    static int squaration(int N) {
        if(N < 10) return (int)Math.pow(N, 2);
        return squaration(N / 10) + squaration(N % 10); 
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(squaration(num));
    }
}