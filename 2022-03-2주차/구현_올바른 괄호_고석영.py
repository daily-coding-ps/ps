def solution(s):
    answer = True

    if s.count('(') != s.count(')'):
        return False

    count = 0
    for i in s:
        if i == '(':
            count += 1
        else:
            count -= 1
        if count < 0:
            return False

    return True