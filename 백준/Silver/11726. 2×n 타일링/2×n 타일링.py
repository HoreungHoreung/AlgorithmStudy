import sys

dp = [0] * 1001
dp[0] = 1
dp[1] = 1

def find_num(n):
    for i in range(2, n + 1):
        dp[i] = (dp[i-1] + dp[i-2])
    return dp[n]
n = int(input())
print(find_num(n) % 10007)
