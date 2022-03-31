def sumInt(serial):
    sum = 0
    for s in serial:
        if s.isdigit():
            sum += int(s)
    return sum 
        
N = int(input())
serial_list = []
for i in range(N):
    serial_list.append(input())

serial_list = sorted(serial_list, key = lambda serial : (len(serial), sumInt(serial), serial))     
            
for serial in serial_list:
    print(serial)