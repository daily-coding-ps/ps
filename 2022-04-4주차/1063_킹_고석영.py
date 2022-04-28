'''
8X8 체스판

킹의 위치, 돌의 위치, 움직이는 횟수 N
R: 한 칸 오른쪽으로
L: 한 칸 왼쪽으로
B: 한 칸 아래로
T: 한 칸 위로
RT: 오른쪽 위 대각선으로
LT: 왼쪽  위  대각선으로
RB: 오른쪽 아래 대각선으로
LB: 왼쪽 아래 대각선으로

킹의 마지막 위치
돌의 마지막 위치

파이썬 알파벳 숫자 변환
A 65
B 66
C 67
D 68
E 69
F 70
G 71
H 72
'''

king, stone, N = input().split()
# print('킹: ', king)
# print('돌: ', stone)
# print('N: ', N)

direction = {
    'R': (0, 1),
    'L': (0, -1),
    'B': (1, 0),
    'T': (-1, 0),
    'RT': (-1, 1),
    'LT': (-1, -1),
    'RB': (1, 1),
    'LB': (1, -1),
}


# 위치 0 - 8로 변환
king_x, king_y = ord(king[0]) - ord('A'), int(king[1]) - 1
stone_x, stone_y = ord(stone[0]) - ord('A'), int(stone[1]) - 1
# print('king의 x, y 좌표: (', king_x, king_y, ')')
# print('stone의 x, y 좌표: (', stone_x, stone_y, ')')

for _ in range(int(N)):
    move = input()
    direc_x, direc_y = direction[move]
    
    kmx = king_y - direc_y[move] # 킹 행
    kmy = king_x - direc_x[move] # 킹 열
    smx = stone_y - direc_y[move] # 돌 행
    smy = stone_x - direc_x[move] # 돌 열
    
    
    # 범위제한
    if 0 < kmx < 9 and 0 < kmy < 9 :  #  격자
        if chr(ord('A') + kmy) == stone[0] and kmx == int(stone[1]):
            if 0 < smx < 9 and 0 < smy < 9:
                stone = chr(ord('A') + smy) + str(smx)
                king = chr(ord('A') + kmy) +  str(kmx)
                continue
            continue
        
        king = chr(ord('A') + kmy) + str(kmx)


print(king)
print(stone)
