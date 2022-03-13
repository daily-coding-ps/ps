import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SkillTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String skill = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] skill_trees = new String[st.countTokens()];
        for (int i = 0; i < st.countTokens(); i++) {
            skill_trees[i] = st.nextToken();
        }
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String temp = skillTree; // 필수스킬만 포함할 스킬트리

            for (int i = 0; i < skillTree.length(); i++) {
                String substring = skillTree.substring(i, i + 1);

                // 필수스킬이 아닐 경우 공백으로 치환
                if (!skill.contains(substring)) {
                    temp = temp.replace(substring, "");
                }
            }

            // 필수스킬과 일치하는 경우
            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }

        return answer;
    }
}
