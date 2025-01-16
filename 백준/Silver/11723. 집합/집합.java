import java.io.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch(command) {
                case "add" :
                    set.add(num);
                    break;
                case "remove" :
                    set.remove(num);
                    break;
                case "check" :
                    if(set.contains(num)) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "toggle" :
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all" :
                    for(int j = 1; j <= 20; j++) {
                        set.add(j);
                    } break;
                case "empty" :
                    set.clear();
                    break;
            }
        }


//        int[][] set = new int[21][1];
//        //set[0][0] = 0;
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String command = st.nextToken();
//            if(command.equals("add")) {
//                int num = Integer.parseInt(st.nextToken());
//                if(set[num][0] == 0) set[num][0] = 1;
//            }
//            else if(command.equals("remove")) {
//                int num = Integer.parseInt(st.nextToken());
//                if(set[num][0] == 1) set[num][0] = 0;
//            }
//            else if(command.equals("check")) {
//                int num = Integer.parseInt(st.nextToken());
//                bw.write(set[num][0] + "\n");
//            }
//            else if(command.equals("toggle")) {
//                int num = Integer.parseInt(st.nextToken());
//                if(set[num][0] == 1) set[num][0] = 0;
//                else set[num][0] = 1;
//            }
//            else if(command.equals("all")) {
//                for(int j = 0; j < 21; j++) set[j][0] = 1;
//            }
//            else {
//                set = new int[21][1];
//            }
//        }
        br.close();
        bw.flush();
        bw.close();
    }
 }
