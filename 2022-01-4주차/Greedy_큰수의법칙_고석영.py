# N: 배열의 크기
# M: 숫자가 더해지는 횟수
# K: 연속해서 더해지는 최대 횟수 

# # n, m, k 공백을 기준으로 구분하여 입력받기 
n, m, k = map(int, input().split())

# 숫자들을 공백을 기준으로 구분하여 입력받으 후 리스트로 만들기
number_list = list(map(int, input().split()))
number_list.sort(reverse=True) # 내림차순 정렬

# 최종값
result = 0

while True:
    for i in range(k):
        if m == 0:
            break
        result += number_list[0]
        m -= 1
    if m == 0:
        break
    result += number_list[1]
    m -= 1
    
print(result)
        


    



        
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     