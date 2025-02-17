import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String command = sc.next();
            if(command.equals("add")) {
                int K = sc.nextInt();
                int V = sc.nextInt();
                hashMap.put(K, V);
            }
            else {
                int num = sc.nextInt();
                if(command.equals("find")) {
                    if(hashMap.containsKey(num)) {
                        System.out.println(hashMap.get(num));
                    } else {
                        System.out.println("None");
                    }
                } else{
                    hashMap.remove(num);
                }
            }
        }
    }
}