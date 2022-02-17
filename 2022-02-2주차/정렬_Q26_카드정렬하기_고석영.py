'''
import sys
input = sys.stdin.readline

n = int(input())
card = []
for i in range(n):
    dummy = int(input())
    card.append(dummy)
total = 0

for i in range(n - 1):
    card_sum = card[0] + card[1]
    del card[0:2]
    total += card_sum
    card.append(card_sum)
    card.sort()
print(total)
'''

import heapq

n = int(input())

heap = []
for i in range(n):
    data = int(input())
    heapq.heappush(heap, data)
    
result = 0

while len(heap) != 1:
    one = heapq.heappop(heap)
    two = heapq.heappop(heap)
    
    sum_value = one + two
    result += sum_value
    heapq.heappush(heap, sum_value)
    
print(result)