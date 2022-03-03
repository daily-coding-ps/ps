t = int(input()) # 테스트 케이스 수 입력

# 테스트 케이스(Test Case) 입력
for tc in range(t):
    
    # 금광 정보 입력
    n, m = map(int, input().split()) # 행 열
    array = list(map(int, input().split())) # 각 위치에 매장된 금의 개수
    
    # dp 테이블 초기화 (2차원 리스트 초기화해서 블럭화)
    dp = []
    index = 0
    for i in range(n):
        # m 단위로 슬라이싱해서 dp 테이블에 담기
        dp.append(array[index:index + m]) 
        index += m 
    
    # 다이나믹 프로그래밍 진행 (보텀업)
    for j in range(1, m): # 각 열을 이동해가면서 확인
        for i in range(n):
            # 왼쪽 위에서 오는 경우
            if i == 0: # 범위 제한; 인덱스를 벗어날 경우 해당 값 0 처리
                left_up = 0 
            else:
                left_up = dp[i - 1][j - 1]
            # 왼쪽 아래에서 오는 경우
            if i == n - 1: # 범위 제한; 인덱스를 벗어나면 해당 값 0 처리
                left_down = 0
            else:
                left_down = dp[i + 1][j - 1]
            # 왼쪽에서 오는 경우
            left = dp[i][j - 1]
            # 현재 매장된 금 + (왼쪽 위/왼쪽/왼쪽 아래) 중 가장 큰 값
            dp[i][j] = dp[i][j] + max(left_up, left_down, left) 
    
    result = 0
    # 반복문으로 가장 오른쪽에 있는 열에 기록되어 있는 값 중에서 가장 큰 값 찾기
    for i in range(n):  
        result = max(result, dp[i][m - 1])
        
    print(result)   