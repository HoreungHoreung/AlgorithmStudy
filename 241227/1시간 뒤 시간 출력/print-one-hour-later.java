import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        String[] strArr = s.split(":");
        int a = int(strArr[0]);
        int b = int(strArr[1]);
        System.out.println(strArr[0] + 1 + ":" + strArr[1]);
    }
}