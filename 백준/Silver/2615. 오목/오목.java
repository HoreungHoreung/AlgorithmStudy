import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 19;
    private static int[][] board = new int[SIZE][SIZE];
    
    // 4방향: 오른쪽, 아래, 오른쪽아래 대각선, 오른쪽위 대각선
    private static int[] dx = {0, 1, 1, -1};
    private static int[] dy = {1, 0, 1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 위치에서 4방향 검사
        for(int j = 0; j < SIZE; j++) {  // 열 우선 순회 (왼쪽부터)
            for(int i = 0; i < SIZE; i++) {  // 행
                if(board[i][j] != 0) {
                    int color = board[i][j];
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int count = 1;
                        
                        // 해당 방향으로 연속된 돌 개수 세기
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        
                        while(nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && 
                              board[nx][ny] == color) {
                            count++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }
                        
                        // 반대 방향도 확인
                        nx = i - dx[dir];
                        ny = j - dy[dir];
                        
                        while(nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && 
                              board[nx][ny] == color) {
                            count++;
                            nx -= dx[dir];
                            ny -= dy[dir];
                        }
                        
                        // 정확히 5개인 경우
                        if(count == 5) {
                            // 시작점 찾기 (가장 왼쪽 또는 가장 위)
                            int startX = i;
                            int startY = j;
                            
                            // 반대 방향으로 가면서 시작점 찾기
                            while(true) {
                                int prevX = startX - dx[dir];
                                int prevY = startY - dy[dir];
                                
                                if(prevX < 0 || prevX >= SIZE || prevY < 0 || prevY >= SIZE || 
                                   board[prevX][prevY] != color) {
                                    break;
                                }
                                
                                startX = prevX;
                                startY = prevY;
                            }
                            
                            System.out.println(color);
                            System.out.println((startX + 1) + " " + (startY + 1));
                            return;
                        }
                    }
                }
            }
        }
        
        System.out.println(0);
    }
}