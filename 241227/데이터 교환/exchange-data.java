public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a = 5, b = 6, c = 7;
        temp1 = b;
        temp2 = c;
        b = a;
        c = b;
        a = c;
        System.out.printf("%d\n%d\n%d", a, b, c);

    }
}