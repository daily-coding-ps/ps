from itertools import permutations

def solution(expression):
    # 연산자 조합 만들기
    operand = []
    if "*" in expression:
        operand.append("*")
    if "+" in expression:
        operand.append("+")
    if "-" in expression:
        operand.append("-")
    operand_permutation = list(permutations(operand))

    # 토큰화
    tokens = []
    token = ''
    for i in range(len(expression)):
        if expression[i] == '*' or expression[i] == '+' or expression[i] == '-':
            tokens.append(token)
            token = ''
            tokens.append(expression[i])
        else:
            token += expression[i]
        
        if i == len(expression)-1:
            tokens.append(token)
    
    # 계산 시작
    answers = []
    for operands in operand_permutation:

        tempTokens = tokens.copy() # 토큰 배열 복사
        for operand in operands:
            index = 0
            while index < len(tempTokens):
                if tempTokens[index] == operand:
                    if operand == "*":
                        newToken = int(tempTokens[index-1]) * int(tempTokens[index+1])
                    elif operand == "+":
                        newToken = int(tempTokens[index-1]) + int(tempTokens[index+1])
                    elif operand == "-":
                        newToken = int(tempTokens[index-1]) - int(tempTokens[index+1])

                    del tempTokens[index-1:index+2]
                    tempTokens.insert(index-1,str(newToken))
                    index = index-1
                else:
                    index+=1

        answers.append(abs(int(tempTokens[0])))
                    
    return max(answers)
