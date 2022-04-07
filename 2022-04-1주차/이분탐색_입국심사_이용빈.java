import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) { // 심사하는 사람의 수가 더 많거나 같음 -> 시간을 줄인다
                end = mid - 1;
                answer = mid;
            } else {// 심사하는 사람의 수가 적다 -> 시간을 늘린다
                start = mid + 1;
            }
        }

        return answer;
    }
}
