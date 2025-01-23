import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Integer[] arr2 = new Integer[n];
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            arr2[i] = num;
        }

        Integer[] arr3 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Arrays.sort(arr3, Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}