import java.io.*;
import java.util.*;
// 10:00 시작 ->
/*
    1. 두 파일의 길이와 내용이 완전히 동일한 경우는 없다 -> 0을 붙여서 새롭게 만들어도 같은경우 X
    2. set의 길이와 총 N의 길이가 같아지는 순간이 답 -> 메모리 초과
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> files = new ArrayList<>();
        int maxLength = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> file = new ArrayList<>();
            while(true) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                file.add(num);
            }
            maxLength = Math.max(maxLength, file.size());
            files.add(file);
        }

        for(List<Integer> file : files) {
            int size = file.size(); //리스트의 길이는 가변이니까 주의
            for(int i = 0; i < maxLength - size; i++) {
                file.add(0);
            }
        }

        int K = maxLength;
        StringBuilder cur = new StringBuilder();
        for(int i = 0; i < maxLength; i++) {
            Set<String> set = new HashSet<>();
            for(int j = 0; j < i; j++) {
                for(List<Integer> file : files) {
                    cur.append(file.get(j)).append(" ");
                }

                set.add(cur.toString());
                cur = new StringBuilder();
            }

            if(set.size() == N) {
                K = i + 1;
                break;
            }
        }

        System.out.println(K);
        br.close();
    }
}
