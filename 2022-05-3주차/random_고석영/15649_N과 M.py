N, M = map(int, input().split())
result = []

def dfs():
    if len(result) == M:
        print(' '.join(map(str, result)))
        return
    
    for i in range(1, N + 1):
        if i not in result:
            result.append(i):
                dfs()
                result.pop()

dfs()
