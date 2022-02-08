# n 가로(행) m 세로(열)
n , m = map(int, input().split())

#2차원 리스트 맵 입력받기
graph = []
for i in range(n):
    graph.append(list(map(int,input())))
print(graph)
# DFS 를 통해 특정 노드 방문 -> 연결된 노드 방문
# x = 행 , y = 열
def dfs(x,y):
    #범위를 벗어나는 경우 종료
    if x <= -1 or x >=n or y<=-1 or y >=m:
        return False

    #현재 노드를 방문하지 않았다면
    if graph[x][y] == 0:
        # 해당 노드 방문 처리
        graph[x][y] = 1
        # 상, 하, 좌, 우의 위치도 모두 재귀 호출
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

# 모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        #현 위치에서 DFS 수행
        if dfs(i,j) == True:
            result += 1

print(result)