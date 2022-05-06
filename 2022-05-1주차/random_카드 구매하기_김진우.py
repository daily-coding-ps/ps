'''# 첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
#
# 둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)

n = int(input())

card_list = list(map(int, input().split()))
# print(f' card[0] : {card_list[0]}')
# print(card_list)
ans = []
for i in range(1, n+1):
    ans.append((n//i)*card_list[i-1])

# print(ans)
# print(int(max(ans)))

max_num = int(max(ans))
max_index = ans.index(max_num)
# print("index : "  , ans.index(max_num))
if n - ans.index(max_num)>0:
    ans.pop(ans.index(max_num))
    max_num = int(max(ans))
    # print(max_num)
    # max_index = ans.index(max_num)
    # print(n-ans.index(max_num)-2)
    # print("card : " , card_list[n - ans.index(max_num)-2]) # 4 - 3 - 1
    max_num += card_list[n - ans.index(max_num)-2]
# print(f'ans : {ans}')
# print(f'max_num : {max_num}')
# print(f'idx : {max_index}')

print(max_num)'''

n = int(input())
d = [0] * (n + 1)
p = [0] + list(map(int, input().split()))
d[1] = p[1]
for i in range(2, n + 1):
    for j in range(1, i + 1):
        if d[i] < d[i - j] + p[j]:
            d[i] = d[i - j] + p[j]
print(d[n])