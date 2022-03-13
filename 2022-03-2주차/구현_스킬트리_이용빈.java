public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String tmpSkill = skillTree;
            for (int i = 0; i < skillTree.length(); i++) {
                String tmp = skillTree.substring(i, i + 1);
                if (!skill.contains(tmp)) {
                    tmpSkill = tmpSkill.replace(tmp, "");
                }
            }

            if (skill.indexOf(tmpSkill) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("BCD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

}
