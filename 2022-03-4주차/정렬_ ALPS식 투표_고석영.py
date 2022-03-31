'''
1) 득표율 전체의 5% 이상인 스태프만 고려
2) 14개의 점수집합
3) 후보 스태프가 받은 칩 개수 카운트
'''
'''
235217
3
A 107382
C 18059
B 43265
'''
X =  int(input())
N = int(input())
result = []
staff_list = []
for _ in range(N):
    staff, vote = input().split()
    staff_list.append((staff, int(vote)))

# print(staff_list)

# 1) 후보 제외
candidate = []
for staff, vote in staff_list:
    if vote  >=  X * 0.05:
        candidate.append([staff, vote])
        
# print(candidate)  

# 2) 점수 집합
score = []
for staff, vote in candidate:
    for i in range(1, 15): # 1 ~ 14
        score.append([staff, vote / i])
score.sort()


