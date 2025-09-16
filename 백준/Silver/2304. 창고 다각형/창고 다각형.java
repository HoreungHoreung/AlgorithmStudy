import java.io.*;
import java.util.*;
// 11:00 시작 -> 11:35분 종료
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int maxX = -1, maxY = -1;

        int[][] buildings = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            buildings[i][0] = x;
            buildings[i][1] = y;
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
        }

        Arrays.sort(buildings, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int hMax = 0;
        for(int i = 0; i < N; i++) hMax = Math.max(hMax, buildings[i][1]);


        //최고높이 구간 구하기 -> 이 구간에서는 모두 최고높이로 간주
        int L = -1, R = -1;
        for(int i = 0; i < N ;i++) {
            if(buildings[i][1] == hMax) {
                L = i;
                break;
            }
        }
        for(int i = N - 1; i >= 0; i--) {
            if(buildings[i][1] == hMax) {
                R = i;
                break;
            }
        }

        int area = 0;

        //왼쪽 누적
        int curH = buildings[0][1];
        int curX = buildings[0][0];
        for(int i = 1; i <= L; i++) {
            if(buildings[i][1] >= curH) {
                area += (buildings[i][0] - curX) * curH;
                curH = buildings[i][1];
                curX = buildings[i][0];
            }
        }

        // 오른쪽 누적 -> 거꾸로
        curH = buildings[N - 1][1];
        curX = buildings[N - 1][0];
        for (int i = N - 2; i >= R; i--) {
            if (buildings[i][1] >= curH) {
                area += (curX - buildings[i][0]) * curH;
                curH = buildings[i][1];
                curX = buildings[i][0];
            }
        }

        area += hMax * (buildings[R][0] - buildings[L][0] + 1);
        
        System.out.println(area);
        br.close();
    }
}
