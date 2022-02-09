from collections import deque
# 도시의 개수 N,
# 도로의 개수 M,
# 거리 정보 K,
# 출발 도시의 번호 X
n, m, k, x = map(int, input().split())
#4 4  2  1

graph = [[] for _ in range(n+1)]
# [ [], [], [], [] ]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

# graph => [[], [2, 3], [3, 4], [], []]

visited = [-1] * (n+1)
# [-1, -1, -1, -1, -1] 방문하지 않은 도시는 -1

visited[x] = 0 # 출발도시 X 는 0으로 설정

queue = deque([x])
# queue.append(x)
# print(queue)
# queue에 첫시작 도시 X 먼저 넣음

#queue가 빌때까지 반복
while queue:
    print(f'queue : {queue}')
    print(f'visited : {visited}')
    now = queue.popleft()     # now에는 시작 도시 X(1)이 담기고 queue는 빈상태

    # 현재 도시에서 이동할 수 있는 모든 도시 확인
    for next_nod in graph[now]:
        print(f'next_nod : {next_nod}')
        print(f'now : {now}')
        print('---------------------------------------')
        #아직 방문하지 않은 도시라면
        if visited[next_nod] == -1:
            print(f'visited[next_nod] : {visited[next_nod]}')
            print(f'visited[now] : {visited[now]}')
            # 최단 거리 갱신
            # 현대 도시와 출발 도시 사이의 거리 + 1
            visited[next_nod] = visited[now] + 1
            print(f'visited[now] : {visited[now]}')
            queue.append(next_nod)
            print(f'queue : {queue}')
            print('*************************************')

# 출발 도시로 부터의 최단 거리가 K인 도시가 존재하지 않는다면
# -1을 출력하기 위해 check 변수를 False로 초기화
check = False

for i in range(1, n+1):
    # 도시들 간의 최단 거리를 확인, K와 동일하다면 출력
    if visited[i] == k:
        print(i)
        # 최단 거리가 K인 도시가 존재한다면 check를 True로 바꾸어 -1이 출력되지 않게함
        check = True
# 최단 거리가 k인 도시가 없다면 -1 출력
if check == False:
    print(-1)