n, m = map(int,(input().split()))
load = [list(map(int,input().split())) for _ in range(n)]
print(load)
max_val= 100 * 1000 + 1
dp = [[[max_val]*3 for _ in range(m)]for _ in range(n)]
print(dp)

for y in range(n):
    if y == 0:
        for x in range(m):
            for d in range(3): # 0:↘  1:↙  2:↓
                dp[y][x][d] = load[y][x]
    else:
        for x in range(m):
            if x == 0:
                dp[y][x][0] = min(dp[y - 1][x + 1][1], dp[y - 1][x + 1][2]) + load[y][x]
                dp[y][x][1] = dp[y - 1][x][0] + load[y][x]
            elif x == m - 1:
                dp[y][x][1] = dp[y - 1][x][2] + load[y][x]
                dp[y][x][2] = min(dp[y - 1][x - 1][0], dp[y - 1][x - 1][1]) + load[y][x]
            else:
                dp[y][x][0] = min(dp[y - 1][x + 1][1], dp[y - 1][x + 1][2]) + load[y][x]
                dp[y][x][1] = min(dp[y - 1][x][0], dp[y - 1][x][2]) + load[y][x]
                dp[y][x][2] = min(dp[y - 1][x - 1][0], dp[y - 1][x - 1][1]) + load[y][x]

answer = 999999
for x in range(m):
    answer = min(min(dp[n-1][x]), answer)

print(answer)