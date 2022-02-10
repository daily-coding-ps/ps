# n: 도시의 개수
# m: 도로의 개수
# k: 거리 정보
# x: 출발 도시의 번호

# 출력조건: 오름차순 출력, 최단거리가 존재하지 않으면 -1 출력

from collections import deque

n, m, k, x = map(int, input().split()) # 4 4 2 1
graph = [[] for _ in range(n + 1)] 
# [[], [], [], [], []] 

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
# [[], [2, 3], [3, 4], [], []]

distance = [-1] * (n + 1)
distance[x] = 0 # 자기 자신과의 거리는 0이므로
# [-1, 0, -1, -1, -1]

queue = deque([x]) 
while queue:
    now = queue.popleft() # now에 1을 담고 queue는 비우기
    
    for next_node in graph[now]:
        # 아직 방문하지 않은 도시라면
        if distance[next_node] == -1:
            distance[next_node] = distance[now] + 1

# 반복문을 돌면서 최단 거리 k에 해당하는 도시의 번호를 오름차순으로 출력
check = False
for i in range(1, n + 1):
    if distance[i] == k:
            print(i)
            check = True

if check == False:
    print(-1)

