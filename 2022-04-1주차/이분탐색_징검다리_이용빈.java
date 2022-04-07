import java.util.Arrays;

public class 징검다리 {

    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2; // 거리의 최솟값
            int remove = 0; // 제거해야할 돌의 갯수
            int prv = 0; // 이전 돌과 현재돌의 거리를 구하고 비교하기위함
            for (int rock : rocks) {
                if (rock - prv < mid) { // 현재 돌 - 이전 돌의 거리가 거리의 최솟값보다 작으면
                    remove++; // 돌 지움
                    if (remove > n) {
                        break;
                    }
                } else {
                    prv = rock;
                }
            }
            if (remove > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}
