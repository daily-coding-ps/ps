n = int(input())
stair = [i for i in range(301)]
for i in range(n):
    stair[i] = int(input())
 
dp = [0 for i in range(301)]
dp[0] = stair[0]
dp[1] = stair[1] + stair[0]
dp[2] = max(stair[2] + stair[1], stair[2] + stair[0])
for i in range(3, n):
    dp[i] = max(
        stair[i] + stair[i - 1] + dp[i - 3],
        stair[i] + dp[i - 2]
        )
    
print(dp[n - 1])