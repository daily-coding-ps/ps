package 스터디.PS3월2주차;

import java.util.Stack;

public class PS0317_Bracket {
    public static void main(String[] args) {
        Solution sol = new Solution();

        boolean solution = sol.solution("(())()");
        System.out.println(solution);
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                }else{
                    if (stack.isEmpty()) {
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }else{
                return false;
            }
        }
    }
}
