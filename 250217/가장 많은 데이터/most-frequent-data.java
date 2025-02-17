import java.io.*;
import java.util.*;

public class Main{
    public static final int MAX_N = 10000;
    public static int[] stringCnt = new int[MAX_N];
    public static HashMap<String, Integer> stringToIndex = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        
        int maxCnt = 0;
        String mostFrequent = null;

        for(int i = 0; i < N; i++) {
            String currString = br.readLine().trim();
            stringToIndex.put(currString, stringToIndex.getOrDefault(currString, 0) + 1);

            if(stringToIndex.get(currString) > maxCnt) {
                maxCnt = stringToIndex.get(currString);
                mostFrequent = currString;
            }
        }
        bw.write(Integer.toString(maxCnt));
        br.close();
        bw.flush();
        bw.close();
    }
}