import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String str = sc.next();

        // 문자열의 길이를 구합니다.
        int len = str.length();

        // 앞에서 2번째 원소를 제거합니다. (이때 문자열의 길이가 1 감소하는것을 반드시 기억합니다)
        str = str.substring(0, 1) + str.substring(2);
        len--;

        // 뒤에서 2번째 원소를 제거합니다.
        str = str.substring(0, len - 2) + str.substring(len - 1);
        len--;
            
        // 앞에서 2번째, 뒤에서 2번째 원소가 제거된 문자열을 출력합니다.
        System.out.println(str);
    }
}