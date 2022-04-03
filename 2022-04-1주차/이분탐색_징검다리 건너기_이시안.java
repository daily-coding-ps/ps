package programmers;

public class SteppingStone {
    public static void main(String[] args) {
        SteppingStone steppingStone = new SteppingStone();

        System.out.println(steppingStone.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0; // 건널 수 없는 돌 개수

        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++; // 건널 수 없으면 돌 개수 증가
            } else {
                cnt = 0; // 건널 수 있으면 초기화
            }

            if (cnt == k) {
                return false; // k 이상이면 점프해서 건널 수 없음
            }
        }
        return true; // 건널 수 있음
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1;
        int high = 200000000; // stone은 최소 1 ~ 최대 200,000,000
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2; // 징검다리를 건널 친구 수
            if (!cross(stones, k, mid)) {
                high = mid - 1; // 다리를 건널 수 있으면 더 많은 인원이 건널 수 있도록 증가
            } else {
                low = mid + 1; // 건널 수 없으면 건널 수 있도록 감소
                answer = Math.max(answer, mid); // 건널 수 있는 친구 수 저장
            }
        }

        return answer;
    }
}
