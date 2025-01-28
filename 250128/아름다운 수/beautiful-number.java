import java.util.*;

public class Main {
    private static ArrayList<Integer> array = new ArrayList<>();
    private static int n;
    private static int cnt = 0;

    public static void choose(int remaining) {
        // 배열 크기가 n에 도달하면 경우의 수를 증가
        if (remaining == 0) {
            cnt++;
            return;
        }

        // 가능한 숫자를 탐색 (1부터 n까지)
        for (int i = 1; i <= remaining; i++) {
            // 숫자 i를 추가
            for (int j = 0; j < i; j++) {
                array.add(i);
            }

            // 백트래킹: 남은 공간에서 i만큼 차감
            choose(remaining - i);

            // 숫자 i를 제거 (백트래킹)
            for (int j = 0; j < i; j++) {
                array.remove(array.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        choose(n); // 총 n개의 숫자를 채우는 경우 탐색
        System.out.println(cnt);
    }
}