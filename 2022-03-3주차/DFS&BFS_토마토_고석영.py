from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])
 
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
queue = deque([])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i, j])
                           
bfs()
for i in graph:
    for j in i:
        if j == 0:
            print(-1)       
    result = max(result, max(i))
print(result - 1)