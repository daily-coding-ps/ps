piece = list(map(int, input().split()))

while True:
    if piece == [1, 2, 3, 4, 5]:
        break
    else:
        for i in range(4):
            if piece[i] > piece[i + 1]:
                piece[i], piece[i + 1] = piece[i + 1], piece[i]
                
                print(' '.join(list(map(str, piece))))
            
