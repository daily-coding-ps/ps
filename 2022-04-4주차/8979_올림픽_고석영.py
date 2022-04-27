N, K = map(int, input().split())
medal_list = []

for _ in range(N):
    medal_list.append(list(map(int, input().split())))

medal_list.sort(key = lambda x: (x[1], x[2], x[3]), reverse=True)

for i in range(N):
    if medal_list[i][0] == K:
        index = i
index = K  
 
for i in range(N):
    if medal_list[index][1:] == medal_list[i][1:]:
        print(i + 1)
        break
