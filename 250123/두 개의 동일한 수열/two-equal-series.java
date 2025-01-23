import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i= 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for(int i= 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        
        boolean diff = false;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < n; i++) {
            if(A[i] != B[i]) {
                diff = true;
                break;
            }
        }

        if(diff) System.out.println("No");
        else System.out.println("Yes");

    }
}