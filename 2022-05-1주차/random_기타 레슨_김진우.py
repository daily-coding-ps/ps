
# 블루레이에는 총 N개의 강의
# i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화
# M개의 블루레이는 모두 같은 크기

n, m = map(int, input().split())
data = list(map(int, input().split()))
left, right = max(data), sum(data)

while left <= right:
    mid = (left + right) // 2
    cnt = 0
    temp = 0
    for i in range(n):
        if temp + data[i] > mid:
            cnt += 1
            temp = 0
        temp += data[i]

    cnt += 1 if temp else 0

    if cnt <= m:
        right = mid - 1
    else:
        left = mid + 1

print(left)