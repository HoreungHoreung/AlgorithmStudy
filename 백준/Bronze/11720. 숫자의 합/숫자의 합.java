import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ar = sc.next();
        String arr = sc.next();
        int sum = 0;
        for (int i = 0; i < arr.length(); i++) {
            sum += Character.getNumericValue(arr.charAt(i));
        }

        System.out.println(sum);
    }
}
