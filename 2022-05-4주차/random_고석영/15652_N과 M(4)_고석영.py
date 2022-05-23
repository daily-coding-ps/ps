N, M = map(int, input().split())
result = []

def dfs(sp):
    if len(result) == M:
        return print(' '.join(map(str, result)))

    for i in range(sp, N + 1):
        result.append(i)
        dfs(i)
        result.pop()
        
dfs(1)