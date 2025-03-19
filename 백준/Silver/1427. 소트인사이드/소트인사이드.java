import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();
        char[] numArr = num.toCharArray();

        Character[] numArrs = new Character[numArr.length];
        for(int i = 0; i < numArr.length; i++) {
            numArrs[i] = numArr[i];
        }

        Arrays.sort(numArrs, new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numArrs.length; i++) {
            sb.append(numArrs[i] + "");
        }
        System.out.println(sb.toString());
    }
}