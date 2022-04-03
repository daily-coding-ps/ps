# your code goes here

N, M = map(int, input().split())
tree = list(map(int, input().split()))

l, r = 1, 1000000000
res = 0
while l <= r:
	m = (l+r) // 2
	
	get = 0
	for i in tree:
		if i - m > 0:
			get += i - m
	
	if get >= M:
		l =  m + 1
		res = m
	else:
		r = m - 1
		
print(res)
