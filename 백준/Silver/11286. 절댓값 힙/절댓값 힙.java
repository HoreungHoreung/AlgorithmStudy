import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int n;
        int abs;
        public Node(int n, int abs) {
            this.n = n;
            this.abs = abs;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.abs != n2.abs) return n1.abs - n2.abs;
                return n1.n - n2.n;
            }
        });


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().n).append("\n");
                }
            } else {
                pq.offer(new Node(num, Math.abs(num)));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
