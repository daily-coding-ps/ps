package ps.study_3;

import java.util.ArrayList;

public class 수식 최대화 {


    static char[] op = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static long answer;

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20")); // 60420
    }

    public static long solution(String exp) {
        answer = 0;

        // 숫자와 연산자 분리
        String num = "";
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                num += exp.charAt(i);
            } else {
                nums.add(Long.parseLong(num));
                ops.add(exp.charAt(i));
                num = "";
            }
        }
        nums.add(Long.parseLong(num));
        dfs(0, new char[3]);

        return answer;
    }

    public static void dfs(int count, char[] p) {
        if (count == 3) {
            ArrayList<Long> tmpNum = new ArrayList<>(nums); // 계산을 위한 tmpList
            ArrayList<Character> tmpOp = new ArrayList<>(ops); // 계산을 위한 tmpList

            for (char operator : p) { // 우선순위에 따라 계산
                for (int j = 0; j < tmpOp.size(); j++) {
                    if (operator == tmpOp.get(j)) {
                        Long res = calc(tmpNum.remove(j), tmpNum.remove(j), operator);
                        tmpNum.add(j, res);
                        tmpOp.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(tmpNum.get(0)));
            return;

        }

        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                p[count] = op[i];
                dfs(count + 1, p);
                check[i] = false;
            }
        }
    }


    public static Long calc(Long num1, Long num2, char op) {
        switch (op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return 0L;
    }
}
