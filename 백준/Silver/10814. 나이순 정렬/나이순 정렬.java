import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int age;
        String name;
        int seq;

        Person(int age, String name, int seq) {
            this.age = age;
            this.name = name;
            this.seq = seq;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb;

        int N = Integer.parseInt(st.nextToken());
        List<Person> people = new ArrayList<>();
        for(int seq = 0 ; seq < N; seq++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people.add(new Person(age, name, seq));
        }

        Collections.sort(people, Comparator.comparingInt((Person p) -> p.age).thenComparingInt(p -> p.seq));

        StringBuilder sb = new StringBuilder();
        for(Person p : people) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
