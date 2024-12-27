import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        String[] strArr = s.split(":");
        System.out.println(strArr[0] + 1 + "\n" + strArr[1]);
    }
}