import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    private static char[][] board = new char[5][9];
    private static int bestPins, bestMoves;

    private static int countPins() {
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 'o') cnt++;
            }
        }
        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 9;
    }

    private static void dfs(int pins, int moves) {
        boolean moved = false;

        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 9; y++) {
                if(board[x][y] != 'o') continue;

                for(int d = 0; d < 4; d++) {
                    int mx = x + dx[d], my = y + dy[d];
                    int nx = x + 2 * dx[d], ny = y + 2 * dy[d];

                    if (!inRange(mx, my) || !inRange(nx, ny)) continue;
                    if(board[mx][my] == 'o' && board[nx][ny] == '.') {
                        moved = true;
                        board[x][y] = '.';
                        board[mx][my] = '.';
                        board[nx][ny] = 'o';

                        dfs(pins - 1, moves + 1);

                        board[x][y] = 'o';
                        board[mx][my] = 'o';
                        board[nx][ny] = '.';
                    }
                }
            }
        }

        if(!moved) {
            if(pins < bestPins) {
                bestPins = pins;
                bestMoves = moves;
            } else if(pins == bestPins && moves < bestMoves) {
                bestMoves = moves;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            for(int i = 0; i < 5; i++) {
                String str = br.readLine();
                for(int j = 0; j < 9; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            int pins = countPins();
            bestPins = pins;
            bestMoves = 0;

            dfs(pins, 0);

            System.out.println(bestPins + " " + bestMoves);

            br.readLine(); //공백 제거
        }
    }
}