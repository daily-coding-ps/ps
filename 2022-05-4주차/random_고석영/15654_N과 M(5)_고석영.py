N, M = map(int, input().split())
result = []
num_list = list(map(int, input().split()))
num_list.sort()
visited = [False] * N

def dfs():
    if len(result) == M:
        return print(' '.join(map(str, result)))

    for num in num_list:
        if num not in result:
            result.append(num)
            dfs()
            result.pop()            
  
dfs()
