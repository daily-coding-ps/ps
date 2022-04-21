'''
거리두기를 지키고 있으면 1, 아니라면 0을 반환
'''
from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, -1]

def bfs(place):
    start = []
    for i in range(5):
        for j in range(5): 
            if place[i][j] == 'P':
                start.append([i, j]) # 확인할 응시자 확인

    for s in start: # 시작점 리스트에서 응시자 한 명씩 확인
        queue = deque([s])
        visited = [[0] * 5 for i in range(5)] # 방문 체크 리스트
        distance = [[0] * 5 for i in range(5)] # 거리 계산 리스트
        visited[s[0]][s[1]] = 1 # 시작점은 확인했으니 visited에서 1로 체크
        
        while queue: 
            x, y = queue.popleft()
            dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1] # 상하좌우
            
            for i in range(4): 
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < 5  and 0 <= ny < 5 and visited[ny][nx] == 0: # 범위를 벗어나지 않는 조건에서
                    if place[nx][ny]  == '0':
                        queue.append([nx, ny])
                        visited[nx][ny] = 1
                        distance[nx][ny] = distance[x][y] + 1
                    
                    # 거리두기가 지켜지지 않았을 경우
                    if place[nx][ny]  == 'P' and distance[x][y] <= 1: 
                        return 0
    return 1
            
def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    return answer        