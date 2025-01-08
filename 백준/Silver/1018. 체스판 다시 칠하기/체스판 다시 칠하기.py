N, M = tuple(map(int, input().split()))

min_cnt = N * M #최악의 경우

grid = [ #빈 리스트 생성
    [0] * M
    for _ in range(N)
] 

for i in range(N): # 입력값을 grid에 삽입
    arr = input()
    for j in range(M):
        grid[i][j] = arr[j]

def find_place(row_idx, col_idx, start_color):
    cnt = 0
    if start_color == 'W':
        for i in range(8):
            for j in range(8):
                if (i + j) % 2 == 0 and grid[row_idx + i][col_idx + j] != 'W':
                    cnt += 1
                elif (i + j) % 2 == 1 and grid[row_idx + i][col_idx + j] != 'B':
                    cnt += 1
    else:
        for i in range(8):
            for j in range(8):
                if (i + j) % 2 == 0 and grid[row_idx + i][col_idx + j] != 'B':
                    cnt += 1
                elif (i + j) % 2 == 1 and grid[row_idx + i][col_idx + j] != 'W':
                    cnt += 1
    return cnt
    
for i in range(N - 8 + 1):  
    for j in range(M - 8 + 1):
        cnt_W = find_place(i, j, 'W')
        cnt_B = find_place(i, j, 'B')
        min_cnt = min(min_cnt, cnt_W, cnt_B)

print(min_cnt)
            
        