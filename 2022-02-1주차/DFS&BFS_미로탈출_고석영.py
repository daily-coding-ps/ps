from collections import deque

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# 상, 하, 좌, 우 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque() # 큐 생성
    queue.append((x, y))
    # 큐가 빌때까지 반복
    while queue:
        x, y = queue.popleft()
        
        # 현재 위치에서 상, 하, 좌, 우 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 입력받은 공간 범위를 벗어난 경우
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            # 괴물이 있는 경우
            if graph[nx][ny] == 0:
                continue
            # 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    # 최종 지점으로 가면서 수를 증가시켰으므로 
    # 가장  오른쪽 아래까지의 최단 거리를 반환하면 문제의 결과값을 도출할 수 있음
    return graph[n - 1][m - 1]

# bfs 결과 출력
print(bfs(0, 0))
                
        