from collections import deque

def solution(board):
    di = [0, 0, 1, -1]
    dj = [1, -1, 0, 0]
    N = len(board)
    table = [[100000000000] * N for _ in range(N)]
    table[0][0] = 0
    q = deque()
    q.append( (0,0,0,-1) )
    while q:
        ci, cj, cost,prev = q.popleft()
        
        for d in range(4):
            ni, nj = ci + di[d], cj + dj[d]

            next_cost = cost + 100
            if prev != -1 and prev != d:
                next_cost += 500 
                
            if 0<= ni < N and 0 <= nj < N and board[ni][nj] != 1 and table[ni][nj] > next_cost:
                q.append((ni,nj,next_cost,d))
                table[ni][nj] = next_cost
            
    return table[N-1][N-1]

board = [[0,0,0],[0,0,0],[0,0,0]]
print(solution(board))