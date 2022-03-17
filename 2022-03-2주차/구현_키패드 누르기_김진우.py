import numpy as np

def solution(numbers, hand):
    answer = ''
    pad = np.array([[1, 2, 3],[4, 5, 6],[7, 8, 9],['*',0,'#']]) # 키패드로 배열 생성(4 by 3 행렬 형태)
    L = '*' # 왼쪽 엄지 현 위치
    R = '#' # 오른쪽 엄지 현 위치
    for i in numbers:
        if i in [1, 4, 7]: answer += 'L'; L = i;   # 왼쪽 엄지 움직이기
        elif i in [3, 6, 9]: answer += 'R'; R = i; # 오른쪽 엄지 움직이기
        else:
            ir, ic = np.where(pad==f'{i}') # 입력하려는 키 i의 인덱스
            lr, lc = np.where(pad==f'{L}') # 현재 왼쪽 엄지의 인덱스
            rr, rc = np.where(pad==f'{R}') # 현재 오른쪽 엄지의 인덱스

            # 입력하려는 키와 왼쪽or오른쪽 엄지 사이의 거리 : 위or아래로 움직여야하는 거리 + 오른쪽or왼쪽으로 움직여야하는 거리
            i_l = (abs(ir-lr) + abs(ic-lc))[0] # 입력하려는 키 i와 왼쪽 엄지 사이의 거리
            i_r = (abs(ir-rr) + abs(ic-rc))[0] # 입력하려는 키 i와 오른쪽 엄지 사이의 거리

            if i_r > i_l: answer += 'L'; L = i;   # 왼쪽 엄지와의 거리가 더 짧을 때
            elif i_r < i_l: answer += 'R'; R = i; # 오른쪽 엄지와의 거리가 더 짧을 때
            else:
                if hand == 'left': answer += 'L'; L = i;
                else: answer += 'R'; R = i;
    return answer