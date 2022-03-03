# 퇴사
n = int(input())
T = []
P = []
for _ in range(n):
    t,p=map(int,input().split())
    T.append(t)
    P.append(p)

ans = 0

# 종료 : index 가 n을 넘은 경우
# 진행 : index+t[i]가 n보다 작은 경우

def sol(index, profit):
    global ans

    if index > n:
        return
    if index == n:
        ans = max(ans, profit)
        return
    sol(index + 1, profit)
    sol(index + T[index], profit + P[index])

sol(0, 0)
print(ans)