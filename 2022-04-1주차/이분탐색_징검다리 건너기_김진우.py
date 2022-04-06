def solution(stones, k):
    answer = 0
    start, end, mid = 1, max(stones), 0

    while start <= end:
        if (start + end) % 2 == 0:
            mid = (start + end) // 2
        else:
            mid = ((start + end) // 2) + 1

        cnt, max_cnt = 0, 0
        for i in range(len(stones)):
            
            if stones[i] - mid <= 0:
                
                cnt += 1
                max_cnt = max(max_cnt, cnt)
                if max_cnt >= k:
                    break
            else:
                cnt = 0
                
        if max_cnt < k:
            start = mid + 1
            
        elif max_cnt >= k:
            end = mid - 1

    answer = start
    return answer