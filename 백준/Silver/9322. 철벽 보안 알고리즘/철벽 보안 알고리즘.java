import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        List<Integer> order;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            order = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String[] publicKey1 = br.readLine().split(" ");
            String[] publicKey2 = br.readLine().split(" ");
            String[] encrypt = br.readLine().split(" ");
//            System.out.println(Arrays.toString(publicKey1));
//            System.out.println(Arrays.toString(publicKey2));
//            System.out.println(Arrays.toString(encrypt));

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(publicKey1[i].equals(publicKey2[j])) {
                        order.add(j);
                    }
                }
            }

            for(int o : order) {
                sb.append(encrypt[o]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
