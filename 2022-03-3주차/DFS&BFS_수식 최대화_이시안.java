import java.util.ArrayList;

public class MaxExpression {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
    }
}

class Solution {
    static long max = 0;
    static boolean[] visited = new boolean[3]; // 방문 처리용 배열
    static char[] operator = {'+', '-', '*'}; // 연산자는 3개
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> operators = new ArrayList<>();

    long solution(String expression) {
        StringBuilder number = new StringBuilder(); // 숫자를 담을 StringBuilder

        for (char c : expression.toCharArray()) {
            if (c == operator[0] || c == operator[1] || c == operator[2]) {
                operators.add(c);
                numbers.add(Long.parseLong(number.toString()));
                number.delete(0, number.capacity()); // 숫자 초기화
            } else {
                number.append(c); // 숫자 연결
            }
        }

        numbers.add(Long.parseLong(number.toString())); // 마지막 숫자 넣기

        dfs(0, "");

        return max;
    }

    void dfs(int count, String oper) {
        if (count == 3) {
            max = Math.max(max, calculation(oper)); // 최댓값 구하기
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                dfs(count + 1, oper + operator[i]); // 카운트와 연산자 추가 후 재귀 호출
                visited[i] = false; // 다음 재귀 호출을 위해 방문 처리 초기화
            }
        }
    }

    long calculation(String oper) {
        // 숫자와 연산자 리스트 원본을 해치지 않도록 카피
        ArrayList<Long> copyNumbers = new ArrayList<>(numbers);
        ArrayList<Character> copyOperators = new ArrayList<>(operators);
        long result = 0;

        for (char op : oper.toCharArray()) {
            for (int i = 0; i < copyOperators.size(); i++) {
                if (op == copyOperators.get(i)) { // 현재 연산자가 카피한 연산자 리스트의 연산자와 일치하면 연산 수행
                    switch (copyOperators.get(i)) {
                        case '+':
                            result = copyNumbers.get(i) + copyNumbers.get(i + 1);
                            break;
                        case '-':
                            result = copyNumbers.get(i) - copyNumbers.get(i + 1);
                            break;
                        case '*':
                            result = copyNumbers.get(i) * copyNumbers.get(i + 1);
                            break;
                    }

                    copyNumbers.remove(i + 1); // 피연산자 제거
                    copyNumbers.set(i, result); // 결과값을 리스트에 추가
                    copyOperators.remove(i); // 연산자 제거
                    i--; // 바뀐 지점부터 연산을 수행하기 위해 감소
                }
            }
        }
        return Math.abs(result); // 절댓값으로 변환
    }
}