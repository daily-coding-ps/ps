import json
def solution(s):
    s = s[2:]
    s = s[:-2]
    s = s.split("},{")
    for i in range(len(s)):
        temp = list(map(int,s[i].split(",")))
        s[i] = (len(temp),temp)
    s.sort()

    answer = []
    for _, s_list in s:
        for num in s_list:
            if not num in answer:
                answer.append(num)
    return answer