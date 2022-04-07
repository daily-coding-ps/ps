def solution(distance, rocks, n):
    answer = 0
    
    rocks.sort()
    rocks.append(distance)
    
    l, r  = 0, 1000000000
    while l <= r:
        m = (l+r) // 2
        
        curr = 0
        cnt = 0
        
        for i in rocks:
            if (i - curr) < m:
                cnt += 1
            else:
                curr = i
                
        if cnt <= n:
            answer = m
            l = m + 1
        else:
            r = m - 1
    
    return answer