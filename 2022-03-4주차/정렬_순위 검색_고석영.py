'''
- : 어떤 조건이어도 상관없다

'''
def solution(info, query):
    data = dict()
    for a in ['cpp', 'java', 'python', '-']:
        for b in ['backend', 'frontend', '-']:
            for c in ['junior', 'senior', '-']:
                for d in ['chicken', 'pizza', '-']:
                    data.setdefault((a, b, c, d), list())
                    
    for i  in info:
        i = i.split() # 공백 기준으로 나누기
        for a in [i[0], '-']:
            for b in [i[1], '-']:
                for c in [i[2], '-']:
                    for d in [i[3], '-']:
                        data[(a, b, c, d)].append(int(i[4]))
                        
    for k in data:
        data[k].sort()
        
    
    # 이진탐색        
    answer = list()
    for q in query:
        q = q.split()
        
        pool =  data[(q[0], q[2], q[4], q[6])] # and 제외
        find = int(q[7])
        l = 0
        r = len(pool)
        mid = 0
        while l < r:
            mid = (r + l) // 2
            if pool[mid] >= find:
                r = mid
            else:
                l = mid + 1
                
        answer.append(len(pool) - 1)

    return answer