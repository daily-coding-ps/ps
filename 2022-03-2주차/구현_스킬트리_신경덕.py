def solution(skill, skill_trees):
  answer = 0

  for st in skill_trees:
    skill_list = list(skill)

    for s in st:
      if s in skill:
        if s != skill_list.pop(0):
          break
    else:
      answer += 1

  return answer