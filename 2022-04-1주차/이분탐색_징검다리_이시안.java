import java.util.Arrays;

public class Jingumdari {
    public static void main(String[] args) {
        Jingumdari jingumdari = new Jingumdari();
        System.out.println(jingumdari.solution(18, new int[]{2, 8, 9, 10, 11, 12, 13}, 6));
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int mid = 0; // 돌 사이의 거리값
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 0; // 제거할 돌의 개수
            int current = 0; // 현재 돌의 위치 시작은 0

            for (int rock : rocks) {
                if (rock - current < mid) {
                    cnt++; // 거리값보다 작은 값이 있으므로 돌 제거
                } else {
                    current = rock; // 기준이 되는 돌 변경
                }
            }

            if (distance - current < mid) cnt++; // 마지막 돌까지의 거리도 계산

            /**
             * 제거된 돌이 적음 = 기준을 넓힘
             * 제거된 돌이 많음 = 기준을 좁힘
             */
            if (cnt <= n) {
                answer = mid > answer ? mid : answer;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
