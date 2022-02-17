def solution(N, stages):
    answer = []
    player = len(stages)
    
    for stage in range(1, N + 1):
        count = stages.count(stage)
        if player == 0:
            fail = 0
        else:
            fail = count / player
        answer.append((stage, fail))
        player -= count
        
    answer.sort(key= lambda x: x[1], reverse=True)
    answer = [i[0] for i in answer]
    return answer
    