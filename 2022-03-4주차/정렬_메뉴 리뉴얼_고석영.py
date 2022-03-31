import itertools
from collections import Counter

def solution(orders, course):
    
    answer = []
    
    for c in course:
        temp = []
        for order in orders:
            combi = itertools.combinations(sorted(order), c)
            temp += combi
        
        my_dict = Counter(temp)
        
        if len(my_dict)  > 0:
            
            max_ = max(list(my_dict.values()))
            if max_ >= 2:
                for key_, values_ in my_dict.items():
                    if values_  == max_:
                        answer.append(''.join(map(str, key_)))
    
    answer = sorted(answer)
    
    return answer