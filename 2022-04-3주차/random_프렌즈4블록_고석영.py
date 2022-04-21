def solution(m, n, board):
    answer = 0

    for i in range(len(board)): # board 배열로 만들기                
        popped = board.pop(0) 
        board.append([p for p in popped])

    while True: # 터진 블록이 없을 때까지                               
        checked = [] # 이번 턴에  터져야 할 블록들 모음                          
        for i in range(m - 1):                
            for j in range(n - 1):
                if board[i][j] == "0": # 이미 블록이 터져 빈 자리일 경우 패스        
                    continue
                # 얀속으로 두 개가 동일한 블록이라면
                if board[i][j] == board[i][j + 1]: 
                     # 밑에 두 개도 동일한지 확인하고 동일할 경우 터져야 할 블록들 전부 저장
                    if board[i][j] == board[i + 1][j] and board[i][j + 1] == board[i + 1][j+1]:
                        checked.append((i, j))
                        checked.append((i, j + 1))
                        checked.append((i + 1, j))
                        checked.append((i + 1, j + 1))        
        
        # 터질 블록 없을 경우 종료
        if len(checked) == 0:            
            break
        else:
            answer += len(set(checked)) # 블록 터뜨리기
            for c in checked:
                board[c[0]][c[1]] = '0'

            for c in reversed(checked): 
                check_n = c[0] - 1
                put_n = c[0]
                
                # 터진 블록 자리에 블록 내리기  
                while check_n >= 0:      
                    if board[put_n][c[1]] == "0" and board[check_n][c[1]] != "0":
                        board[put_n][c[1]] = board[check_n][c[1]]
                        board[check_n][c[1]] = "0"
                        put_n -= 1

                    check_n -= 1

    return answer