from itertools import permutations


def isMatch(candidate, banned_id):
    # 문자마다 비교
    for i in range(len(candidate)):
        if banned_id[i] == '*':
            continue
        # 불량 사용자의 문자가 *이 아니고 아이디가 다르면 False
        elif (banned_id[i] != candidate[i]):
            return False
    return True


def check(candidate, banned_id):
    # 조합에 따른 유저 ID의 후보와 불량 사용자 아이디 각각을 비교
    for i in range(len(banned_id)):
        # 불량 사용자와 유저의 아이디 길이가 다르면 false
        if len(candidate[i]) != len(banned_id[i]):
            return False
        # 길이가 같다면 해당 쌍을 비교
        if isMatch(candidate[i], banned_id[i]) is False:
            return False
    return True


def solution(user_id, banned_id):
    answer = []

    for candidate in permutations(user_id, len(banned_id)):
        if check(candidate, banned_id) is True:
            res = set(candidate)
            if res not in answer:
                answer.append(res)

    return len(answer)