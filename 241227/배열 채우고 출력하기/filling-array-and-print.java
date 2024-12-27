import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}