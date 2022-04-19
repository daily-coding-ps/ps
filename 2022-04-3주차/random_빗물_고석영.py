H, W = map(int, input().split())
blocks = list(map(int, input().split()))

left, right =  0, W - 1
max_left = blocks[left]
max_right = blocks[right]

result = 0

while left < right:
    max_left = max(max_left, blocks[left])
    max_right = max(max_right, blocks[right])
    
    if max_left >= max_right: 
        result += max_right - blocks[right]
        right -= 1
    else: 
        result += max_left -  blocks[left]
        left += 1
    
print(result)