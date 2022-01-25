n = int(input())
member = list(map(int,input().split()))
member.sort()
# print(n, member)
# print(min(member))
# min_member = min(member)

a = 0 # n만큼의 수를 받기위한 변수
count = 0 # 파티 수

for i in member:
    a += i
    if a == n :
        count += 1
        a = 0 # n만큼 되면 초기화

print(f'파티수 : {count}')