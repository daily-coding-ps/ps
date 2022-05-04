from collections import deque

N, K = map(int, input().split())
queue = deque([i for i in range(1, N + 1)]) 
answer = []
ord = K - 1 

while queue:
    for i in range(ord):
        queue.append(queue.popleft())
    answer.append(queue.popleft()) 

print("<" + ", ".join(list(map(str, answer))) + ">")
        
