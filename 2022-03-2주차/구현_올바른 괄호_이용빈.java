import java.util.Stack;

public class 올바른_괄호 {

    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        answer = stack.isEmpty();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("(())"));
    }
}
