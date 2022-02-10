# 0: 빈칸; 연구소 
# 1: 벽
# 2: 바이러스

# 벽은 3개만 세울 수 있음
# 안전영역의 최댓값을 출력
# 1. 벽을 선택한다.
# 2. 바이러스를 퍼트린다.
# 3. 바이러스가 퍼지지 않은 안전지역 면적을 구한다.
# 1~3번의 과정을 벽을 선택하는 모든 경우의 수에 대해서 반복하고, 마지막에 안전지역의 max값 리턴

n, m = map(int, input().split())
data = [] # 초기 맵 리스트 
temp = [[0] * m for _ in range(n)] # 벽을 설치한 뒤의 맵 리스트

for _ in range(n):
    data.append(list(map(int, input().split())))
    
# 4가지 이동 방향에 대한 리스트    
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# dfs에서 사용할 전역변수 result 설정
result = 0

# BFS를 이용해 각 바이러스가 사방으로 퍼지도록 하는 메소드
# 벽인 1은 그대로 두고
# 빈칸(연구소)인 0에 바이러스인 2를 퍼뜨림
def virus(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 상, 하 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if temp[nx][ny] == 0:
                # 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                 temp[nx][ny] = 2
                 virus(nx, ny)

# 현재 맵에서 안전 영역의 크기 계산하는 메소드
# 맵을 돌면서 0인 경우 score값 1씩 증가한 뒤 score값 반환
def get_score():
    score = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                score += 1
    return score

# BFS을 이용해 울타리를 설치하면서, 매번 안전 영역의 크기 계산
def dfs(count):
    global result
    # 울타리가 3개 설치된 경우
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = data[i][j]
                
        # 각 바이러스의 위치에서 전파 진행
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus(i, j)
                    
        # 안전 영역의 최댓값 계산
        result = max(result, get_score())
        return
    
    # 빈 공간에 울타리 설치
    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                count += 1
                dfs(count)
                data[i][j] = 0
                count -= 1
                
dfs(0)
print(result)

# 빈공간에 울타리 설치
# - for문으로 초기 맵 리스트인 data를 돌면서 0이 나오는 경우르 1로 대체 
# - 완전탐색: 0인 모든 부분 중 세 곳을 선택해서 1을 넣을 때, 나올 수 있는 모든 조합을 탐색
# - dfs()를 마친 후 원상복귀: data와 count 초기상태를 계속적으로 활용

# 울타리가 3개 설치된 경우 바이러스 전파
# - 울타리 3개가 설치된 시점에 조건문을 통해 data의 해당 내용을 temp에 넣어줌
# - temp로 옮긴 정보를 이용하여 바이러스(2)의 위치에서 근처에 연구소(0)이 있을 때 바이러스 전파
# - virus(x, y) 함수의 매개변수 x, y 값 == temp에서 2가 발견된 순간의 x, y 좌표
# - virus 함수 내에서 해당 좌표의 상하좌우에서 0을 발견하면 2로 변경하는 작업을 재귀적으로 수행

# 안전 영역의 최댓값 계산
# - 전파가 가능한 곳을 모두 2로 만든 후에 남아있는 0의 걋수를 세서 안전영역을 계산
# - get_score()는 현재 temp 상태를 기준으로 0의 갯수를 세서 반환
# - 반환된 결과는 다른 조합에서의 score가 저장되어 있을 result와 비교하여 최댓값을 result에 저장할 수 있도록 함
# - 그래야 모든 경우를 탐색하여 안전 영역의 최댓값을 찾을 수 있음
# - 울타리를 세 개 설치했을 때까지만 if 문을 실행하고, 그 이상은 탐색을 하지 않기 위해서 