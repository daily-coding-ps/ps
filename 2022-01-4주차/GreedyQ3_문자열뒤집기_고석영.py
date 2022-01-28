# 풀이
# 1) 0에서 1로 바꿀지 /  1에서 0으로 바꿀지 판별
# 2) 1)에서 비교한 결과 최소값을 선택하고 해당 횟수 출력

s = input()

# 0과 1 판별
count_zero = 0
count_one = 0

for i in range(0, len(s) - 1):
    if s[i] != s[i + 1]:
        if s[i + 1] == "1":
            count_zero += 1
        else:
            count_one += 1

result = min(count_zero, count_one) 
print(result)           
    