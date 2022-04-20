package programmers;

import java.util.Arrays;

public class TreasureMap {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr2 = new int[]{27, 56, 19, 14, 14, 10};
        TreasureMap treasureMap = new TreasureMap();
        System.out.println(Arrays.toString(treasureMap.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            // 이진수로 변환하면서 앞자리는 0으로 채움
            String x = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String y = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));

            for (int j = 0; j < n; j++) {
                if (x.charAt(j) == '1' || y.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
