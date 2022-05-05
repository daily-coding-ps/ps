def solution(dartResult):
    dart = list(dartResult)
    score = []

    for i in range(len(dart)):
        if dart[i] == '1' and dart[i + 1] == '0':
            score.append('10')
        elif dart[i] == '0' and dart[i - 1] == '1':
            continue
        else:
            score.append(dart[i])

    answer = []

    for j in score:
        if j.isdigit():

            num = int(j)
        elif j.isalpha():
            if j == 'S':
                num = num ** 1
                answer.append(num)
            elif j == 'D':
                num = num ** 2
                answer.append(num)
            elif j == 'T':
                num = num ** 3
                answer.append(num)
        if j == '*':
            if len(answer) >= 2:
                answer[-1] = answer[-1] * 2
                answer[-2] = answer[-2] * 2
            else:
                answer[-1] = answer[-1] * 2

        if j == '#':
            answer[-1] = answer[-1] * (-1)

    return sum(answer)