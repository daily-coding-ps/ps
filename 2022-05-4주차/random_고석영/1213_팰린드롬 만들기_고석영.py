from collections import Counter

n = list(map(str, input()))
n.sort()
check = Counter(n)

count = 0 
center = "" 
result = ""

for i in check:
    if check[i] % 2 != 0:
        count += 1
        center += i
        n.remove(i) 
        
    if count > 1:
        print("I'm Sorry Hansoo")
        break

if count <= 1:
    for i in range(0, len(n), 2):
        result += n[i]
        
    print(result +  center + result[::-1])
    