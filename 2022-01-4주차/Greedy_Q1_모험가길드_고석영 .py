n = int(input())
list = list(map(int, input().split()))
list.sort()
print(n)
print(list)

group, count = 0

for fear in list:
    count += 1
    if count >= fear:
        group += 1
        count = 0

print(group)