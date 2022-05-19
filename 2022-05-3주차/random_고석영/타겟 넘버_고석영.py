from collections import deque

def solution(numbers, target):
    answer = 0
    queue = deque()
    
    N = len(numbers)
    queue.append([-numbers[0], 0])
    queue.append([+numbers[0], 0])
    
    while queue:
        num, i = queue.popleft()
        if i + 1 == N:
            if num == target:
                answer += 1
        else:
            queue.append([num - numbers[i + 1], i + 1])
            queue.append([num + numbers[i + 1], i + 1])
    return answer

