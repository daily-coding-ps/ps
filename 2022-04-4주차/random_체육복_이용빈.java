import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2}, new int[]{2, 3}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        for (int lostN : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lostN - 1 || reserve[i] == lostN + 1) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
