import java.util.*;
public class Main {
    
    private static ArrayList<Integer> array = new ArrayList<>();
    private static int n;
    private static int cnt = 0;
    
    public static void choose(int currNum) {
        if(array.size() > n) return;
        if(array.size() == n) {
            cnt++;
            return;
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                array.add(i);
            }
            choose(currNum + i);
            for(int j = 0; j < i; j++) {
                array.remove(array.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        choose(1);
        System.out.println(cnt);
    }
}