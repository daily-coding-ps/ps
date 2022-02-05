package 이코테.DFS_BFS;

import java.util.*;
public class Q18 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution("()))((()");

    }

    static class Solution {
        int pos;

        public String solution(String p) {
            //1번
            if(p.isEmpty()){
                return p;
            }

            //2번
            boolean isBalance = balanceString(p);
            String u = p.substring(0, pos);
            String v = p.substring(pos, p.length());

            //3번
            if(isBalance){
                //3-1
                return u + solution(v);
            }else{
                //4번
                //4-1
                String answer = "(";

                //4-2
                answer += solution(v);

                //4-3
                answer += ')';

                //4-4
                for (int i = 1; i < u.length() - 1; i++) {
                    if (u.charAt(i) == '(') {
                        answer += ")";
                    }else{
                        answer += "(";
                    }
                }

                return answer;
            }

        }

        public boolean balanceString(String s) {
            Stack<Character> stack = new Stack<>();
            boolean checkBalance = true;
            int left = 0;
            int right = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '(') {
                    left++;
                    stack.push('(');
                }else{
                    right++;
                    if (stack.isEmpty()) {
                        checkBalance = false;
                    }else {
                        stack.pop();
                    }
                }

                if (left == right) {
                    pos = i + 1; // u 와 v 자르는 지점 ,  u 의 끝 , v 의 시작
                    return checkBalance;
                }
            }
            return true;
        }
    }
}
