import sys
input=sys.stdin.readline

T = int(input())  # 테스트케이스

for i in range(0, T):
    Cnt = 1
    people = []
    N = int(input())
    for i in range(N):
        document, interview = map(int, sys.stdin.readline().split())
        people.append([document, interview])

    print(f'people : {people}')
    people.sort()  # 서류 기준 오름차순 정렬
    print(f'people : {people}')
    Max = people[0][1]
    print(f'max : {Max}')
    for i in range(1, N):
        if Max > people[i][1]:
            Cnt += 1
            Max = people[i][1]

    print(Cnt)