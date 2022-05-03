N, M = map(int, input().split())
nums = list(map(int, input().split()))

l, r = 1, 10000 * 100000
res = r

while l <= r:
    m = (l+r) // 2

    cnt = 0
    sum = 0
    for i in nums:
        if (sum + i) <= m:
            sum += i
        else:
            sum = i
            cnt += 1

    if sum <= m:
        cnt += 1

    if max(nums) > m:
        cnt = M + 1

    if cnt <= M:
        r = m - 1
        res = m
    else:
        l = m + 1

print(res)
