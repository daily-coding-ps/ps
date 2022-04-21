def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        # 2진수 변환(변환시 접두어 제외하고 변환)
        arr1[i], arr2[i] = int(format(arr1[i], 'b')), int(format(arr2[i], 'b'))
        
        k = " "
        a = str(arr1[i] + arr2[i])
        
        if len(a) < n:
            a = '0' * (n - len(a)) + a
        
        for j in a:
            if j == '0':
                k += " "
            else:
                k += "#"
        answer.append(k)
    return answer