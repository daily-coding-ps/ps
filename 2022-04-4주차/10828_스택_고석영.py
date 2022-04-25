import sys
input = sys.stdin.readline

N = int(input())
stack = []
for i in range(N):
    cmd = input().split()
    word = cmd[0]
    
    # push
    if word == 'push':
        stack.append(cmd[1])
        
    # pop
    elif word == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    
    # size
    elif word == 'size':
        print(len(stack))
    
    # empty    
    elif word == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    
    # top    
    elif word == 'top':
        if len(stack) == 0:
            print(-1)
        else: 
            print(stack[-1])