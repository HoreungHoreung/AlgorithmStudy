import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n, k;
    public static String t;
    public static int cnt;
    
    public static String[] str = new String[MAX_N];
    public static String[] words = new String[MAX_N];
    
    // a가 b로 시작하는지를 확인합니다.
    public static boolean startsWith(String a, String b) {
        // b의 길이가 더 길 수는 없습니다.
        if((int) a.length() < (int) b.length())
            return false;
        
        // b의 길이만큼 살펴보며, a와 문자열이 완벽히 동일한지 확인합니다.
        for(int i = 0; i < (int) b.length(); i++)
            if(a.charAt(i) != b.charAt(i))
                return false;
        
        // 전부 확인했는데도 오류가 없다면, prefix라 할 수 있습니다.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언
        n = sc.nextInt();
        k = sc.nextInt();
        t = sc.next();
        for(int i = 0; i < n; i++) {
            str[i] = sc.next();
            
            // 문자열 t로 시작하는 경우인지 확인하고,
            // 그 경우에만 목록에 넣어줍니다.
            if(startsWith(str[i], t))
                words[cnt++] = str[i];
        }
        
        // 정렬을 진행합니다.
        Arrays.sort(words, 0, cnt);
        
        System.out.print(words[k - 1]);
    }
}
