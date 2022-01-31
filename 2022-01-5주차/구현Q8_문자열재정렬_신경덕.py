S = input() + "@"

num, res = "".join(sorted(S)).split("@")

res += str(sum(list(map(int,list(num)))))

print(res)
