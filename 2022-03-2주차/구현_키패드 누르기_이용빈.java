public class 키패드_누르기 {

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftHand = 10; // * = 10
        int rightHand = 12; // # = 12

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) { // 왼쪽 키패드
                answer.append("L");
                leftHand = number;
            } else if (number == 3 || number == 6 || number == 9) { // 오른쪽 키패드
                answer.append("R");
                rightHand = number;
            } else {
                int leftHandDistance = getDistance(leftHand, number);
                int rightHandDistance = getDistance(rightHand, number);

                if (leftHandDistance > rightHandDistance) { // 오른손이 가까우면
                    answer.append("R");
                    rightHand = number;
                } else if (leftHandDistance < rightHandDistance) { // 왼손이 가까우면
                    answer.append("L");
                    leftHand = number;
                } else { // 거리가 같으면 손잡이 기준
                    if (hand.equals("right")) {
                        answer.append("R");
                        rightHand = number;
                    } else {
                        answer.append("L");
                        leftHand = number;
                    }
                }
            }
        }
        return answer.toString();
    }

    private static int getDistance(int idx, int number) {
        // 숫자 0에 손이 위치할 경우 치환
        idx = (idx == 0) ? 11 : idx;
        number = (number == 0) ? 11 : number;

        int x = (idx - 1) / 3;
        int y = (idx - 1) % 3;
        int numX = number / 3;
        int numY = 1; // center 1 고정

        return Math.abs(x - numX) + Math.abs(y - numY);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

}
