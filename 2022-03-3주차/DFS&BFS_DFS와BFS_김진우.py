from collections import deque

# 정점의 개수 N,
# 간선의 개수 M,
# 탐색을 시작할 번호 V
n, m, v = map(int, input().split())
# print(n, m, v)
#4 5 1
graph = [[] for _ in range(n+1)]
# graph = [ [], [], [], [], [] ]
# 1 2
# 1 3
# 1 4
# 2 4
# 3 4
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1, n+1):
    graph[i].sort()

# print(graph)

visited = [False] * (n+1)
# print(visited)


def dfs(v):
    visited[v] = True
    print(v, end=' ')
    # print(visited)
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited[v] = True
    while queue:
        # print(queue)
        # print(visited)
        a = queue.popleft()
        print(a, end=' ')
        for i in graph[a]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
dfs(v)
print("")
visited = [False] * (n+1)
bfs(v)
