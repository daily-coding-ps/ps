from itertools import combinations


def solution(info, query):
    answer = []
    # 0:개발언어, 1:직군, 2:경력, 3:소울푸드, 4:점수
    combi_dict = dict()

    for information in info:
        temp = information.split(' ')
        for i in range(5):
            for combi_info in combinations(temp[:4], i):
                sum_info = ''.join(combi_info)
                if sum_info in combi_dict:
                    combi_dict[sum_info].append(int(temp[-1]))
                else:
                    combi_dict[sum_info] = [int(temp[-1])]

    for key in combi_dict.keys():
        combi_dict[key].sort()

    for commands in query:
        combi_command = commands.split(' ')
        target = int(combi_command[-1])
        combi_command = combi_command[:-1]

        for _ in range(3):
            combi_command.remove('and')
        while '-' in combi_command:
            combi_command.remove('-')
        combi_command = ''.join(combi_command)

        if combi_command in combi_dict:
            scores = combi_dict[combi_command]

            left = 0
            right = len(scores) - 1

            while left <= right:
                mid = (left + right) // 2

                if target > scores[mid]:
                    left = mid + 1
                elif target <= scores[mid]:
                    right = mid - 1

            answer.append(len(scores) - left)
        else:
            answer.append(0)

    return answer
