import java.io.*;
import java.util.*;

public class Main {
    private static class Car{
        int num, weight;
        public Car(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    private static int[][] parkingLots;

    private static int emptyLot() {
        int space = -1;
        for(int i = 0; i < parkingLots.length; i++) {
            if(parkingLots[i][1] == 0) return i;
        }
        return space;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //주차장 요금, 사용여부(0 -> empty, n -> full(n번차 사용중))
        parkingLots = new int[N][2];
        for(int i = 0; i < N; i++) {
            parkingLots[i][0] = Integer.parseInt(br.readLine());
        }
        //차량번호별 무게 -> 1번부터 시작
        int[] carWeights = new int[M + 1];
        for(int n = 1; n <= M; n++) {
            carWeights[n] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> command = new ArrayDeque<>();
        for(int i = 0; i < M * 2; i++) {
            command.offerLast(Integer.parseInt(br.readLine()));
        }
        Deque<Integer> waitLine = new ArrayDeque<>();


        int result = 0;
        while(!command.isEmpty() || !waitLine.isEmpty()) {
            int curr = command.pollFirst();

            if(curr >= 0) { // 입차시
                int emptySpace = emptyLot();
                if(emptySpace == -1) { //빈공간 없다면 대기줄로
                    waitLine.offerLast(curr);
                } else { //빈공간 있다면
//                    if(waitLine.isEmpty()) {
//                        parkingLots[emptySpace][1] = curr;
//                    } else {
//                        parkingLots[emptySpace][1] = waitLine.pollFirst();
//                        waitLine.offerLast(curr);
//                    }
                    parkingLots[emptySpace][1] = curr;
                }
            } else { //출차시
                curr = Math.abs(curr);
                for(int i = 0; i < N; i++) {
                    if (parkingLots[i][1] == curr) {
                        result += (parkingLots[i][0] * carWeights[curr]);
                        parkingLots[i][1] = 0;
                        if(!waitLine.isEmpty()) { //만약 대기중인 차가 있다면 바로 주차
                            parkingLots[i][1] = waitLine.pollFirst();
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
