N, K = map(int, input().split())
X = list(map(int, input().split()))

left = 1
right = (10 ** 5 * 20) + 1

answer = 0
while left <= right:
    mid = (left + right) // 2
    group_count = 0
    score = 0
    
    for x in X:
        score += x
        if score >= mid:
            group_count += 1
            score = 0
    
    if group_count < K:
        right = mid - 1
    else:
        answer = mid
        left = mid + 1

print(answer)