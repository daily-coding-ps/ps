# 값이 특정 범위에 속하는 데이터 개수 구하기
from bisect import bisect_left, bisect_right

# 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index

n, x = list(map(int, input().split()))
array = list(map(int, input().split()))

# 변수로 카운트 횟수 선언
count = count_by_range(array, x, x)


if count == 0: # 값이 x인 원소가 하나도 없다면 -1 출력 
    print(-1)
else: 
    print(count)


