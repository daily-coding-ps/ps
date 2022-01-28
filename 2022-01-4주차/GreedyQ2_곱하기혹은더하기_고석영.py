s = input()
result = 0

for x in s:
    if int(x) <= 1:
        result += int(x)
    else:
        if result <= 1:
            result += int(x)
        else:
            result *= int(x)

print(result)
