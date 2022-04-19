import java.util.*;

public class 표 편집 {

    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for (String query : cmd) {
            char c = query.charAt(0);
            switch (c) {
                case 'D':
                    // 현재 위치에서 n칸 아래에 있는 행 선택
                    k += Integer.parseInt(query.substring(2));
                    break;
                case 'U':
                    // 현재 위치에서 n칸 위에 있는 행 선택
                    k -= Integer.parseInt(query.substring(2));
                    break;
                case 'C':
                    // deleteStack 에 k 푸쉬 후 사이즈 감소
                    stack.push(k);
                    size--;
                    if (k == size) { // 만약 k가 끝칸이었다면 k도 한칸 감소
                        k--;
                    }
                    break;
                case 'Z': // 다시 꺼냈을 때의 행 값이 k값보다 같거나 작다면 k값을 더함
                    if (stack.pop() <= k) {
                        k++;
                    }
                    size++; // 전체 사이즈 증가
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(Math.max(0, size))); // 현재 사이즈 만큼 O

        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X"); // 스택에서 꺼내면서 지워진거 X 삽입
        }
        return sb.toString();
    }
}
