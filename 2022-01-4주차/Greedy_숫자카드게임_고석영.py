n, m = map(int, input().split())
my_list = [list(map(int, input().split())) for _ in range(n)]
result = 0

for card in my_list:
    min_card = min(card)
    result = max(result, min_card)
print(result)