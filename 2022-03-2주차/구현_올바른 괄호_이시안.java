import java.util.Stack;

public class CorrectBracket {
    public static void main(String[] args) {
        System.out.println(solution(br.readLine()));
    }

    static boolean solution(String s) {
        // 첫 글자가 ')'이면 false
        if (s.charAt(0) == ')') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (Character bracket : s.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket); // '('라면 스택에 추가
            } else if (bracket == ')' && !stack.empty()) {
                stack.pop(); // ')' 이면서 스택이 비어있지 않다면 스택에서 제거
            } else {
                return false; // '('가 아니면서 비어있다면 false
            }
        }

        return stack.empty(); // 비어있으면 true
    }
}
