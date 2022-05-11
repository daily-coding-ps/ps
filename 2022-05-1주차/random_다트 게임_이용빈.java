public class 다트 게임 {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
    public static int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();
        int[] score = new int[4];
        int cnt = 0;

        for (int i = 0; i < darts.length; i++) {
            if (darts[i] >= '0' && darts[i] <= '9') { // 점수 체크
                cnt++;
                if (darts[i] == '1' && darts[i + 1] == '0') { // 10점 체크
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if (darts[i] == 'D') { // 더블
                score[cnt] = (int) Math.pow(score[cnt], 2);
            } else if (darts[i] == 'T') { // 트리플
                score[cnt] = (int) Math.pow(score[cnt], 3);
            } else if (darts[i] == '*') {
                if (cnt > 1) { // 2번, 3번의 경우 n - 1번째의 점수를 두배
                    score[cnt - 1] *= 2;
                }
                score[cnt] *= 2; // 해당점수도 2배
            } else if (darts[i] == '#') {
                score[cnt] *= -1; // 해당점수 -
            }
        }
        return score[1] + score[2] + score[3];
    }
}
