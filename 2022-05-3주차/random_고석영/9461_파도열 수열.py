T = int(input())

for tc in range(T):
    N =  int(input())
    if N == 1:
        print(1)
    elif N == 2:
        print(1)
    elif N == 3:
        print(1)
    elif N == 4:
        print(2)
    elif N == 5:
        print(2)
        
    else:
        dp = [0] * (N + 1)
        dp[1], dp[2], dp[3], dp[4], dp[5] = 1, 1, 1, 2, 2
        for i in range(6, N + 1):
            dp[i] = dp[i - 1] + dp[i - 5]
        
        print(dp[N])
            