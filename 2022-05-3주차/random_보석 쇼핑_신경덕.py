def solution(gems):
    answer = [0, len(gems)-1]
    dict = {}
    for i in gems:
        dict[i] = 0 
    target_len = len(dict)
    gem_len = 0
    
    start = 0 
    end = 0 
    gem_len += 1
    dict[gems[0]] += 1
    
    while end < len(gems) and start < len(gems):
        if target_len != gem_len:
            end += 1
            if end == len(gems):
                break
            if dict[gems[end]] == 0:
                gem_len += 1
            dict[gems[end]] += 1
        else:
            if end-start < answer[1] - answer[0]:
                answer = [start, end]
            if dict[gems[start]] == 1:
                gem_len -= 1
            dict[gems[start]] -= 1
            start+=1
    return [answer[0]+1, answer[1]+1] 