def zip(s, size):
    res = ""
    i = 0
    while i < len(s):
        temp = s[i:i+size]
        cnt = 1
        for j in range(i+size, len(s), size):
            if temp == s[j:j+size]:
                cnt += 1
            else:
                break
        if cnt == 1:
            res += temp
            i += (size)
        else:
            res += str(cnt) + temp
            i += size*cnt
    return len(res)



ans = 10000000
s = input()
for i in range(1, len(s)+1):
    ans = min(ans, zip(s,i) )

print(ans)
