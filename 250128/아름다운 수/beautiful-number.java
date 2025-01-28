import java.util.*;

public class Main {
    public static int n;
    public static int ans;
    public static ArrayList<Integer> seq = new ArrayList<>();

    public static boolean isBeautiful() {
        for(int i = 0; i < n; i += seq.get(i)) {
            if(i + seq.get(i)  > n) return false; // 범위주의

            for(int j = i ; j < i + seq.get(i); j++) {
                if(seq.get(i) != seq.get(j)) return false;
            }
        }
        return true;
    }

    public static void countSeq(int cnt) {
        if(cnt == n) {
            if(isBeautiful()){
                ans++;
            }
            return;
        }

        for(int i = 1; i <= 4 ; i++) {
            seq.add(i);
            countSeq(cnt + 1);
            seq.remove(seq.size() - 1);
        }
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        countSeq(0);
        System.out.println(ans);
        
    }
}