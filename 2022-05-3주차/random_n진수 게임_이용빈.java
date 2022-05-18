package ps.study_10;

public class _1 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
    }

    /**
     * @param n : 진법
     * @param t : 튜브가 말해야 하는 숫자
     * @param m : 게임 참가 인원
     * @param p : 튜브의 순서
     */
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; sb.length() < t * m; i++) { // t * m 까지 해야 튜브가 t개를 말할 수 있음
            sb.append(Integer.toString(i, n).toUpperCase()); // 진법변환
        }

        p--; // 0번 부터 시작하기 위함
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(i * m + p));
        }

        // 011011100
        // m : 2, p : 1
        // 0, 2, 4, 8

        return answer.toString();
    }

}
