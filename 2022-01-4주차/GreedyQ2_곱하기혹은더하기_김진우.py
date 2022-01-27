
#문자열 s
s = input()

list_s = []
for i in s:
    list_s.append(int(i))

result = 0

for i in range(len(list_s)):
    num = list_s[i]
    if num<= 1 or result<=1:
        result += num
    else:
        result *= num

print(result)

