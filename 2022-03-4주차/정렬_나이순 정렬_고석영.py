'''
정렬
1) 나이순
2) 나이가 같으면 가입한 순

출력조건
한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력
'''
import sys
input = sys.stdin.readline

n = int(input())
user = []

for i in range(n):
   age, name = map(str, input().split())
   user.append((int(age), i, name))    

user.sort()

for i in range(n):
    print(user[i][0], user[i][2])