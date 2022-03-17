n = int(input())  # 스위치개수

switch = list(map(int, input().split()))
m = int(input())  # 사람수

for _ in range(m):
    student = list(map(int, input().split()))
    if student[0] == 1:
        k = student[1] - 1
        while k < n:
            switch[k] = 1 - switch[k]
            k += student[1]
    else:
        j = student[1] - 1
        switch[j] = 1 - switch[j]

        for a in range(1, n - 1):
            if j - a >= 0 and j + a < n and switch[j - a] == switch[j + a]:
                switch[j - a] = 1 - switch[j - a]
                switch[j + a] = 1 - switch[j + a]

            else:
                break
for i, e in enumerate(switch):
    if i and not (i % 20):
        print()
    print(e, end=' ')