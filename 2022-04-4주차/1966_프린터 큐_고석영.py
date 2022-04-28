from collections import deque 

T = int(input()) 

for tc in range(T):
    N, M = map(int,input().split())
    queue = deque(list(map(int,input().split())))
    idx = deque(list(range(N)))
    
    cnt = 0 
    while queue:
        if queue[0] == max(queue):
            cnt += 1
            queue.popleft()
            if idx.popleft() == M:
                print(cnt)
        else:
            queue.append(queue.popleft())
            idx.append(idx.popleft())