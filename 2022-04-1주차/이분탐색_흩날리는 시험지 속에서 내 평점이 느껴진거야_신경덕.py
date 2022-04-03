N, K = map(int, input().split())
nums = list(map(int, input().split()))

l, r = 0, 20 * N
res = 0
while l <= r:
	m = (l+r) // 2
	
	cnt = 0
	sum = 0
	for i in nums:
		sum += i
		
		if sum >= m:
			cnt += 1
			sum = 0
	
	if cnt >= K:
		l = m + 1
		res = m
	else:
		r = m - 1

print(res)
