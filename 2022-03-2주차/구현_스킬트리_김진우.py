def solution(skill, skill_trees):
    ans = 0
    for skills in skill_trees:
        skill_list = list(skill)
        print(skill_list)
        print(skills)

        for s in skills:
            if s in skill:
                print(s)
                if s != skill_list.pop(0):
                    break
        else:
            ans += 1
    return ans


skill = "CBD"
# skill = list(skill)

skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees))