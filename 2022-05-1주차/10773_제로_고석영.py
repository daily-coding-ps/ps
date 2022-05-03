K = int(input())
# print('K: ', K)
stack = []

for i in range(K):
    m = int(input())
    if m == 0:
        stack.pop()
    else:
        stack.append(m)
    
    
if len(stack) == 0:
    print(0)
else:
    print(sum(stack))
        
    