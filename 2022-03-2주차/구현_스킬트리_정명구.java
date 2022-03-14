//프로그래머스 스킬트리
package 스터디;

public class PS0314_SkillTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CDB"};
        sol.solution(skill, skill_trees);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String skill_tree : skill_trees) {
                String temp = skill_tree;

                for (int i = 0; i < skill_tree.length(); i++) {
                    String s = skill_tree.substring(i, i + 1);

                    if (!skill.contains(s)) {
                        temp = temp.replace(s, "");
                    }
                }

                if (skill.indexOf(temp) == 0) {
                    answer++;
                }

            }
            return answer;
        }
    }
}
