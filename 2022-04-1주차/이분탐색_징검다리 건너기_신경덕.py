def check(m,k):
    global stone
    
    cnt = 0
    for i in stone:
        if i >= m:
            cnt = 0
        else:
            cnt += 1
        if cnt >= k:
            return False
    
    return True

def solution(stones, k):
    global stone
    stone = stones 
    l, r = 1, 200000000
    answer = 0 
    while l <= r:
        m = (l+r) // 2
        
        if check(m,k):
            l = m + 1
            answer = m
        else:
            r = m - 1
    
    return answer
