# n: 열 / m: 행 
n, m = map(int, input().split())

# 2차원 리스트 생성
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

def dfs(x, y):
    # 입력받은 범위를 벗어나는 경우
    if x <= -1 or x >= n or y <= -1 or y <= m:
        return False
    # 현재 노드를 아직 방문하지 않은 경우
    if graph[x][y] == 0:
        # 방문처리
        graph[x][y] == 1
        # 해당 노드의 상, 하, 좌, 우도 재귀적으로 호출(방문처리를 위한 호출)
        dfs(x - 1, y) # 상
        dfs(x + 1, y) # 하
        dfs(x, y - 1) # 좌
        dfs(x, y + 1) # 우
        return True
    return False

# 이중반복문으로 모든 행, 열을 돌면서 아이스크림이 생성되는 결과값 출력
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1
            
print(result)
    
