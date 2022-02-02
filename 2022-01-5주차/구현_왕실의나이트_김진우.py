# 현재 나이트의 위치
input_data = input()
row = int(input_data[1]) #행의 데이터
column = int(ord(input_data[0])) - int(ord('a')) + 1 # 열의 데이터 ord(문자) = 문자에 해당하는 유니코드 정수 반환!

# 나이트의 이동 방향 정의
steps = [(-2,-1), (-1,-2), (1,-2), (2,-1), (2,1), (1,2), (-1,2), (-2,1)]

# 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
result = 0

for step in steps:
    # 이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_column = column + step[1]

    # 해당 위치로 이동이 가능 하면 결과값 +1
    if next_row >=1 and next_row <= 8 and next_column >=1 and next_column <=8:
        result += 1

print(result)