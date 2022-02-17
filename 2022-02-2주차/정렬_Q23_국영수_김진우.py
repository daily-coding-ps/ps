import sys
input = sys.stdin.readline

n = int(input())

s_list = []

for _ in range(n):
    s_list.append(input().split())

# print(s_list)
s_list.sort(key= lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
# 국어 점수가 감소하는 순서로 (내림차순)
# 국어 점수가 같으면 영어 점수가 증가하는 순서로 (오름차순)
# 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 (내림차순)
# 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)(오름차순)

# print(s_list)

for i in  s_list:
    print(i[0])