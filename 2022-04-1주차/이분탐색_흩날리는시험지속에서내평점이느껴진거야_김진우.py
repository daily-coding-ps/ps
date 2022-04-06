n,k = map(int, input().split())
array = list(map(int, input().split()))

left = 0
right = sum(array) + 1
answer = 0

while left <=right:
    mid = (left+right)//2
    # print(f'mid = {mid}')
    count = 0
    score = 0
    for i in array:
        score += i
        if score >= mid:
            count += 1
            # print(f'{count}, {score}')
            score = 0
    if count < k:
        right = mid-1
        # print(f'right = {right}')
    else:
        answer = mid
        left = mid+1
        # print(f'left = {left}')

print(answer)