def solution(s):
    result = []
    if len(s) == 1 :
        return 1
    for i in range(1, (len(s)//2) + 1):
        b = ''
        count = 1
        temp = s[:i]

        for j in range(i, len(s), i):
            if temp == s[ j : i+j ]:
                count += 1
            else:
                if count != 1:
                    b = b + str(count) + temp
                else:
                    b = b + temp
                temp = s[ j : j+i ]
                count = 1
        if count != 1:
            b = b + str(count) + temp
        else:
            b = b + temp

        result.append(len(b))
    return min(result)

solution("aabbaccc")	#7
solution("ababcdcdababcdcd")	#9
solution("abcabcdede")	#8
solution("abcabcabcabcdededededede")	#14
solution("xababcdcdababcdcd")   #17