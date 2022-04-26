T = int(input())

for tc in range(T):
    ps = input()
    stack = []
    
    for p in ps:
        if p == '(':
            stack.append(p)
        elif p == ')':
            if len(stack) != 0 and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(')')
                break
            
    if len(stack) == 0:
        print('YES')
    else:
        print('NO')
            
