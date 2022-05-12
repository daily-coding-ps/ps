'''
1. 한 앵무새는 한 문장. 문장은 여러 단어로 이루어져 있으며, 앵무새는 이 단어들을 순서대로 말한다.
2. 한 앵무새가 단어를 말하고 그다음 단어를 말하기 전에는 약간의 간격.  이때 다른 앵무새가 말을 가로채고 자신의 문장을 말할 수 있음
3. 한 앵무새가 단어를 말하는 도중에, 다른 앵무새가 말을 가로채지 않는다.
4. 어떤 단어도 앵무새가 말하는 모든 문장을 통틀어 2번 등장하지 않음
'''
import sys
from collections import deque

input = sys.stdin.readline


N = int(input()) # 앵무새 수
message_queue = [deque(input().rstrip().split()) for _ in range(N)] # 앵무새가 말한 문장 

check = input().rstrip().split() # 확인할 문장
removed = []

for word in check:
    for i in range(N):
        if message_queue[i] and word == message_queue[i][0]:
            message_queue[i].popleft()
            removed.append(word)
            print(message_queue)
            break

for i in range(N):
    if message_queue[i]:
        print("Impossible")
        exit()
        
if check != removed:
    print("Impossible")
else:
    print("Possible")
        