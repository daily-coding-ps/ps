package programmers;

import java.util.Arrays;

public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }

    static int solution(String dartResult) {
        int[] arr = new int[3];
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char curr = dartResult.charAt(i);
            switch (curr) {
                case 'S':
                    arr[cnt] = Integer.parseInt(sb.toString());
                    sb.delete(0, sb.length());
                    cnt++;
                    break;
                case 'D':
                    arr[cnt] = (int) Math.pow(Double.parseDouble(sb.toString()), 2);
                    sb.delete(0, sb.length());
                    cnt++;
                    break;
                case 'T':
                    arr[cnt] = (int) Math.pow(Double.parseDouble(sb.toString()), 3);
                    sb.delete(0, sb.length());
                    cnt++;
                    break;
                case '*':
                    if (cnt > 1) {
                        arr[cnt - 2] *= 2;
                    }
                    arr[cnt - 1] *= 2;
                    break;
                case '#':
                    arr[cnt - 1] *= -1;
                    break;
                default:
                    sb.append(curr);
            }
        }

        return Arrays.stream(arr).sum();
    }
}
