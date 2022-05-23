N, M = map(int, input().split())
result = []

def dfs(sp):
    if len(result) == M:
        return print(' '.join(map(str, result)))
    
    for i in range(sp, N + 1):
        if i not in result:
            result.append(i)
            dfs(i + 1)
            result.pop()

dfs(1)
