import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            }
            else{
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int curr = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(curr)) {
                sb.append(hashMap.get(curr) + " ");
            } else{
                sb.append(0 + " ");
            }
            
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}