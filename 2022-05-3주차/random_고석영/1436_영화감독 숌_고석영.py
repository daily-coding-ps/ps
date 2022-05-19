N = int(input())
serial = 666

count = 0
while True:
    if "666" in str(serial):
        count += 1
    
    if count == N:
        print(serial)
        break
    
    serial += 1        