def solution(n, times):
    answer = 0
    left, right = 1, max(times) * n

    while left <= right:
        mid = (left + right) // 2
        count = 0
        for i in times:
            count += mid // i
            
        if n <= count:
            right = mid - 1
        else:
            left = mid + 1
    
    answer = left
    return answer
        
