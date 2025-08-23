import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> diaries = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            diaries.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(diaries, (a, b) ->  b - a );

        int totalPay = 0;
        while(diaries.size() > 2) {
//            totalPay += diaries.remove(0);
//            totalPay += diaries.remove(0);
//            diaries.remove(0);

            totalPay += diaries.get(0);
            totalPay += diaries.get(1);

            diaries.remove(0);
            diaries.remove(0);
            diaries.remove(0);
        }

        for(int i = 0; i < diaries.size(); i++) {
            totalPay += diaries.get(i);
        }

        System.out.println(totalPay);
    }
}