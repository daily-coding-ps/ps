def solution(skill, skill_trees):
    answer = 0

    for skills in skill_trees:
        check = []

        for s in skills:
            if s in skill:
                check.append(s)
            # print(check)

        for i in range(len(check)):
            if check[i] != skill[i]:
                break
        else:
            answer += 1

    return answer
