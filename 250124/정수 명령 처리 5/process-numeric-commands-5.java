import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if(command.equals("push_back")){
                    array.add(num);
                }
                else if(command.equals("get")) {
                    bw.write(array.get(num - 1) + "\n");
                }
            }
            else {
                if (command.equals("pop_back")) array.remove(array.size() - 1);
                else if(command.equals("size")) bw.write((array.size()) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }
}