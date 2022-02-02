input_text = sorted(input())
print(input_text)

abc = ""
nums = 0

for text in (input_text):
    if ord(text) >= 65:
        abc += text
    else:
        nums += int(text)

print(abc+str(nums))