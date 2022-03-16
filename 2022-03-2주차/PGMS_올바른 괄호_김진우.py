def solution(input_text):
    count = 0
    for text in input_text:
        if count <0 :
            return False
        if text == '(':
            count += 1
        else:
            count -= 1
    return True if count == 0 else False


print(solution(")()()("))