from itertools import combinations


def solution(relation):
    answer = 0
    rows = len(relation)
    cols = len(relation[0])

    # 유일성
    candidates = []
    for i in range(1, cols + 1):
        candidates.extend(combinations(range(cols), i))  # (0), (1), ... 이렇게 인덱스들이 들어가있다. 0~3까지 모든 조합을 알아내겠다는 뜻이다.

    final = []
    for c in candidates:
        tmp = [tuple(item[key] for key in c) for item in relation]  # 인덱스를 객체로 만들어준다.
        if len(set(tmp)) == rows:  # 모든 조합을 만들어준 tmp에서 중복을 제거한게 원래 행 길이와 같을 경우
            final.append(c)

    answer = set(final)  # set으로 만들어줘야 나중에 discard가 가능하다.

    # 최소성
    # set으로 해주고 순회하면 사전순대로 순회하게 된다는걸 기억해야한다.
    for i in range(len(final)):
        for j in range(i + 1, len(final)):
            if len(final[i]) == len(set(final[i]).intersection(set(final[j]))):
                answer.discard(final[j])

    return len(answer)
