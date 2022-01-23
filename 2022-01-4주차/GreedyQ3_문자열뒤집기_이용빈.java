package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyQ3_문자열뒤집기_이용빈 {

    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String 문자열을 int형 배열로 전환
        int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        // 첫자리가 0인지 1인지 확인후 0이면 zero, 1이면 one에 1을 더함
        checkZeroAndOne(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] != array[i]) { // i번째의 값과 i-1번째의 값이 다르면 i번째 값이 1인지 0인지 판단하여 1을 더함
                checkZeroAndOne(array[i]);
            }
        }
        System.out.println(Math.min(zero, one)); // 최소 횟수 출력
    }

    static void checkZeroAndOne(int value) {
        if (value == 0) {
            zero++;
        } else {
            one++;
        }
    }
}
