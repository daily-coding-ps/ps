n = int(input())

stack = []
result = []
count = 1
check = True
for i in range(n):
    num = int(input())
    
    while count <= num:
        stack.append(count)
        result.append('+')
        count += 1        
        
    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        check = False
        break
        
        
if check == False:
    print('NO')
else:
    for i in result: 
        print(i)