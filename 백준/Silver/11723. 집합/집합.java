import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        int[][] set = new int[21][1];
        //set[0][0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                if(set[num][0] == 0) set[num][0] = 1;
            }
            else if(command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                if(set[num][0] == 1) set[num][0] = 0;
            }
            else if(command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                bw.write(set[num][0] + "\n");
            }
            else if(command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if(set[num][0] == 1) set[num][0] = 0;
                else set[num][0] = 1;
            }
            else if(command.equals("all")) {
                for(int j = 0; j < 21; j++) set[j][0] = 1;
            }
            else {
                set = new int[21][1];
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
 }
