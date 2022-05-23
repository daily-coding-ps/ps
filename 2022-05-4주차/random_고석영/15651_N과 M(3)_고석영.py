N, M = map(int, input().split())
result = []

def dfs():
    if len(result) == M:
        return print(' '.join(map(str, result)))
    
    for i in range(1, N + 1):
        result.append(i)
        dfs()
        result.pop()
        
dfs()