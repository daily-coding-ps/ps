from collections import deque

# 괴물 있는칸 0, 괴물 없는칸 1
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 이동할 네 방향 정의(상, 하, 좌, 우)
dx = [-1, 1, 0, 0]  # 상, 하
dy = [0, 0, -1, 1]  # 좌, 우


def bfs(x, y):
    queue152 = deque()
    queue152.append((x, y))
    # 큐가 빌때까지 반복
    while queue152:
        x, y = queue152.popleft()

        # 현재 위치에서 네 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #미로 찾기 공간을 벗어난 경우 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            #벽인 경우 무시
            if graph[nx][ny] == 0:
                continue
            #해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue152.append((nx, ny))
    # 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[n - 1][m - 1]

print(bfs(0, 0))

'''
입력 예시
5 6
101010
111111
000001
111111
111111
'''
