n = input()

left_sum = 0
right_sum = 0

len = len(n)

for i in range(len//2):
    left_sum += int(n[i])

for j in range(len//2,len):
    right_sum += int(n[j])

# print(left_sum)
# print(right_sum)

if left_sum == right_sum:
    print("LUCKY")
else:
    print("READY")
