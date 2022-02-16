'''
4
5 1 7 9
'''

n = int(input())
house = list(map(int, input().split()))

house.sort()
for i in range(n):
    if i == (n-1) // 2:
        print(house[i])
        break