import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            if (a % 2 != 0) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
        
    }
}