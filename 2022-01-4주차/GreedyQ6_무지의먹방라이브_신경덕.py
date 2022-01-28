"""
3,1,2 5 ==> 1

- 값에 index값을 삽입
prev = 0
food_len = 3
k = 5
pq = [3,0] [1,1] [2,2]

- 0번째 값으로 정렬 
prev = 0
food_len = 3
k = 5
pq = [1,1] [2,2] [3,0]

- pq에서 pop, 값처리
prev = 0
food_len = 3
k = 5 - (1 - 0) * 3 ==> 5 - 3 ==> 2 
pq = [2,2] [3,0]

- pq에서 pop, 값처리 
prev = 1
food_len = 2
k = 2 - (2 - 1) * 2 ==> 2 - 2 ==> 0
pq = [3,0]


- pq의 남은값으로 원래 index로 다시 정렬 해서 값 찾기
prev = 2
food_len = 1
pq = [3,0]

"""

import heapq

def solution(food_times, k):
    answer = -1
    pq = []
    for i, v in enumerate(food_times):
        heapq.heappush(pq, (v, i+1))

    food_len = len(food_times)
    prev = 0

    while pq:
        temp = (pq[0][0] - prev) * food_len

        if k >= temp:
            k -= temp
            prev, _ = heapq.heappop(pq)
            food_len -= 1
        else:
            answer = sorted(pq, key = lambda x: x[1])[k % food_len][1]
            break

    return answer 

