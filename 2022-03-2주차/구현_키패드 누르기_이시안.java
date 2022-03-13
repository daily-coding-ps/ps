package programmers;

public class PressKeypad {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10; // 왼손 시작은 *
        int right = 12; // 오른손 시작은 #

        for (int number : numbers) {
            // 0은 11로 간주
            if (number == 0) {
                number = 11;
            }
            switch (number) {
                // 왼손이 가까운 경우
                case 1:
                case 4:
                case 7:
                    answer.append("L");
                    left = number;
                    break;

                // 오른손이 가까운 경우
                case 3:
                case 6:
                case 9:
                    answer.append("R");
                    right = number;
                    break;

                // 키패드 중앙의 경우
                default:
                    // 절댓값으로 누를 번호의 왼손 거리, 오른손 거리 구하기
                    int leftDistance = (Math.abs((left - number) / 3)) + Math.abs(((left - number) % 3));
                    int rightDistance = (Math.abs((right - number) / 3)) + Math.abs(((right - number) % 3));

                    // 왼손이 가까운 경우
                    if (leftDistance < rightDistance) {
                        answer.append("L");
                        left = number;

                        // 오른손이 가까운 경우
                    } else if (leftDistance > rightDistance) {
                        answer.append("R");
                        right = number;

                        // 거리가 동일한 경우
                    } else {
                        if (hand.equals("left")) {
                            answer.append("L");
                            left = number;
                        } else {
                            answer.append("R");
                            right = number;
                        }
                    }
            }
        }
        return answer.toString();
    }
}
