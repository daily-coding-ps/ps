# 답참조
# 만들어질 수 있는 합의 최솟값과 최댓값으로 범위를 설정하고 반복문을 돌려보려 했으나
# 오류가 나서 실패 ..
n = int(input())
coin_type = list(map(int, input().split()))
coin_type.sort()

makeable = 1
for x in coin_type:
    if makeable < x:
        break
    makeable += x

print(makeable)