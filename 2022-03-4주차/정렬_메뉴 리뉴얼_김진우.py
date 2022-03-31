import itertools, collections


def solution(orders, course):
    global combList

    combList = []
    for order in orders:
        # order 정렬
        order = sorted(order)
        # 각각의 order로 조합만들고 하나의 리스트에 추가
        # for c in course:
        combList += itertools.combinations(order, c)  ### itertools 모듈 사용

    # 회수를 Counter로 계산. 빈도수로 정렬
    ct = collections.Counter(combList).most_common()

    # 메뉴 개수별 빈도수가 제일 큰 것만 결과 리스트에 추가
    # 같은 값이 여러가지면 모두 추가
    answer, resMap = [], {}
    for k, v in ct:
        if len(k) not in resMap.keys() or resMap[len(k)] == v:
            if v <= 1: break
            answer.append(''.join(k))
            resMap[len(k)] = v
    return sorted(answer)