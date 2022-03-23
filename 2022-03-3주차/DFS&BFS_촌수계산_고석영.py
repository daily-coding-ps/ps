'''
DFS
'''
import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            result[i] = result[v] + 1
            dfs(i)

n = int(input())
t1, t2 = map(int, input().split())
m = int(input())

graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
result = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
dfs(t1)

if result[t2] > 0:
    print(result[t2])
else:
    print(-1)