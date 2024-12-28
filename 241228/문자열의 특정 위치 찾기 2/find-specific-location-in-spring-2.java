import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        String[] str = new String[] {"apple", "banana", "grape", "blueberry", "orange"};
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (str[i].charAt(2) == a || str[i].charAt(3) == a) {
                System.out.println(str[i]);
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}