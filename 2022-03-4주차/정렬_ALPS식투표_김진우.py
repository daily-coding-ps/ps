#5% 이하인 후보 제거
#1~14로 나눈 실수값을 딕셔너리로 생성
#sort후 14개 개수 더함

#데이터받기
X=int(input())
N=int(input())
array=[[] for i in range(N)]
for i in range(N):
    name,vote = input().split()
    array[i].append(name)
    array[i].append(int(vote))

#5%미만 후보 제거
data=[]
for name,vote in array:
    if X*0.05<=vote:
        data.append([vote,name])

#후보 리스트 만들기
rate=[]
for vote,name in data:
    for i in range(1,15):
        rate.append([vote/i,name])

#후보 내림차순
rate.sort(reverse=True)

#후보 코인 카운트용 딕셔너리 생성
result={}
for vote,name in data:
    result[name]=0

#1~14 개만 카운트
for vote,name in rate[0:14]:
    result[name]+=1

#이름순으로 정렬
result = sorted(result.items())

#출력
for key, value in result:
    print(key, value)
