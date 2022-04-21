'''
C 삭제
Z 복구
삭제되지 않은 행 O / 삭제된 행 X
'''

'''
- 개체 정의
- 
'''



def solution(n, k, cmd):
    answer =  '' # linked_list는 해당  칸의 이전 값과 가르킬 값을 가지고 있음
    linked_list =  {i: [i - 1, i + 1] for i in range(1, n + 1)} # 1~8로 저장
    cursor = k + 1 
    delete = [] #  삭제 항목 리스트
    res = ['O'] * n # 상태 변화 리스트
    
    for i in cmd:
        print('now cursor: ', cursor)
        print('now linked: ', linked_list)
        if len(i) > 1:
            state, x = i.split(" ") # 명령을 상태, 숫자로 분해
            x = int(x)
            if state == 'D': # 입력받은 숫자만큼 for문으로 cursor 위치 변경
                for i in range(x):
                    cursor = linked_list[cursor][1]
                print('D cursor:', cursor)
                print('D linked :', linked_list)
            elif state == 'U': # 입력받은 숫자만큼 for문으로 cursor 위치 변경
                for i in range(x): 
                    cursor = linked_list[cursor][0]
                print('U cursor:', cursor)
                print('U linked :', linked_list)
        else:
            # 삭제
            if i == 'C': # 현재 cursor의 이전값과 다음값을 가지고 시작
                prev, next = linked_list[cursor]
                delete.append([prev, cursor, next]) # 삭제 항목 리스트에 추가
                res[cursor - 1] = 'X'
                if next == n + 1: # 다음 커서가 표의 범위를 벗어날 경우
                    cursor = linked_list[cursor][0]
                else: 
                    cursor = linked_list[cursor][1]
                
                # 표에서 항목 삭제 후 앞 뒤 항목의 값을 변경
                if prev == 0: 
                    linked_list[next][0] = prev
                elif next  == n + 1:
                    linked_list[prev][1] = next
                print('C cursor:', cursor)
                print('C linked :', linked_list)
            # 복원
            elif i == 'Z': # 삭제 항목 리스트에 추가한 값 pop
                prev, now, next = delete.pop()
                res[now - 1] = 'O' # 상태변화 기억
                
                if prev == 0:
                    linked_list[next][0] = now
                elif next == n + 1:
                    linked_list[prev][1] = now
                else:
                    linked_list[prev][1] = now
                    linked_list[next][0] = now
                print('Z cursor:', cursor)
                print('Z linked :', linked_list)
    
    for x in res:
        answer += x
    
    return answer