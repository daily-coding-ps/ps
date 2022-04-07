def solution(stones, K):
    answer = 0
    left = 1
    right = max(stones)
    size = len(stones)
    copy = [s for s in stones]
    
    while left <= right:
        mid = (left + right) // 2
        for i in range(size):
            x = stones[i] - mid + 1
            stones[i] = x if x > 0 else 0
            
        seq = 0
        for i in range(size):
            if stones[i] == 0: 
                seq += 1
            else: 
                seq = 0   
                
        for i in range(size):
            stones[i] = copy[i]
            
        if seq < K:
            answer = max(answer, mid)
            left = mid + 1
        else:
            right = mid - 1
    
    return answer 