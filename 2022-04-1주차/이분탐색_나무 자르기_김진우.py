N, M = map(int, input().split())
tree_list = list(map(int, input().split()))
start, end = 1, max(tree_list)

while start <= end:
    mid = (start + end) // 2
    tree = 0
    for i in tree_list:
        if i >= mid:
            tree += i - mid

    if tree >= M:
        start = mid + 1
    else:
        end = mid - 1

print(end)
