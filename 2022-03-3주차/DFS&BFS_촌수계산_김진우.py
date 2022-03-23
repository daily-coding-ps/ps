import sys
from collections import deque


# bfs 탐색
def bfs(v, w):
    cnt = 0
    queue = deque([[v, cnt]])
    while queue:
        v, cnt = queue.popleft()

        # 촌수를 계산해야하는 서로 다른 두 사람에 번호가 같아지면 cnt 리턴
        if v == w:
            return cnt

        # 탐색하지 않은 노드라면 탐색하고 카운트
        if not visited[v]:
            cnt += 1
            visited[v] = True

            # 연결된 노드가 탐색하지 않은 노드라면 탐색 리스트에 추가
            for i in result[v]:
                if not visited[i]:
                    queue.append([i, cnt])

    # 모든 노드를 탐색하고도 촌수를 계산해야하는 서로 다른 두 사람에 번호가 같지 않다면 -1 리턴
    return -1


n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())

# 2차원 그래프로 표현
result = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    result[x].append(y)
    result[y].append(x)

# 탐색 여부
visited = [False] * (n + 1)

# 탐색
print(bfs(a, b))
