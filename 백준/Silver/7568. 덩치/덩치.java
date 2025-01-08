import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        int height;
        int weight;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb;

        int N = Integer.parseInt(st.nextToken());

        List <Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }

        int[] ranks = new int[N];
        Arrays.fill(ranks,1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if((people.get(j).height > people.get(i).height) && (people.get(j).weight > people.get(i).weight)) {
                    ranks[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int rank : ranks) {
            sb.append(rank).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
