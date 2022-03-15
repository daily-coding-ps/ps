numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 2]
hand = "right"
answer = " "

keypad = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    "*": [3, 0],
    0: [3, 1],
    "#": [3, 2],
}

left_side = [1, 4, 7]
right_side = [3, 6, 9]

left_thumb = "*"
right_thumb = "#"

print(keypad[left_thumb][0])
for number in numbers:
    if number in left_side:
        answer += "L"
        left_thumb = number
    elif number in right_side:
        answer += "R"
        right_thumb = number
    else:
        left_number = abs((keypad[left_thumb][0] - keypad[number][0])) + abs((keypad[left_thumb][1] - keypad[number][1]))
        right_number = abs((keypad[right_thumb][0] - keypad[number][0])) + abs((keypad[right_thumb][1] - keypad[number][1]))

        if left_number < right_number:
            left_thumb = number
            answer += "L"
        elif left_number == right_number:
            if hand == "left":
                answer += "L"
                left_thumb = number
            else:
                answer += "R"
                right_thumb = number
        else:
            right_thumb = number
            answer += "R"

        